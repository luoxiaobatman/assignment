package com.luoxiaobatman.assignment.ant;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.DefaultAnswer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Cache;
import com.luoxiaobatman.assignment.support.Factory;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * unstable
 * concurrent
 */
public class AggUnorderedString implements Solution {
    private final List<String> list;

    private volatile Collection<Queue<Wrapper>> cache = null;

    public AggUnorderedString(List<String> list) {
        this.list = list;
    }

    @Cache
    @Override
    public Answer solve() {
        Answer answer = Factory.of(Answer.class).newInstance();

        Map<String, Queue<Wrapper>> hashMap = new ConcurrentHashMap<>();
        cache = list
                .parallelStream()
                .map(Wrapper::new)
                .reduce(
                        hashMap, (m, s) -> {
                            if (Objects.isNull(s.getS())) {
                                return m;
                            }
                            Queue<Wrapper> defaultQ = new LinkedBlockingQueue<>();
                            defaultQ.offer(s);
                            Queue<Wrapper> q = m.putIfAbsent(s.getKey(), defaultQ);
                            if (q != null) {
                                Wrapper first = q.peek();
                                s.computeAndFillOrdered();
                                assert first != null;
                                if (Objects.isNull(first.getOrdered())) {
                                    synchronized (first) {
                                        if (Objects.isNull(first.getOrdered())) {
                                            first.computeAndFillOrdered();
                                        }
                                    }
                                }
                                if (first.getOrdered().equals(s.getOrdered())) {
                                    q.offer(s);
                                } else {
                                    q = m.putIfAbsent(s.getOrdered(), defaultQ);
                                    if (q != null) {
                                        q.offer(s);
                                    }
                                }
                            }
                            return m;
                        }, (a, b) -> a
                ).values();
        answer.setAnswer(hashMap);
        return answer;
    }

    public static class Wrapper {
        /**
         * 原始字符串
         */
        private final String s;
        /**
         * {charPointSum}_{lengthOfS}
         */
        private final String key;
        /**
         * ordered s, based on decoded byte value
         */
        private String ordered;

        public String getS() { return s; }
        public String getKey() { return key; }
        public String getOrdered() { return ordered; }

        public void computeAndFillOrdered() {
            byte[] toOrder = s.getBytes(StandardCharsets.UTF_8);
            Arrays.sort(toOrder);
            ordered = new String(toOrder, StandardCharsets.UTF_8);
        }

        Wrapper(String s) {
            this.s = s;
            long sum = 0;
            if (Objects.isNull(s)) {
                this.key = "";
            } else {
                for (Byte b : s.getBytes()) {
                    sum += b.longValue();
                }
                this.key = String.format("%s_%s", sum, s.length());
            }
            this.ordered = null;
        }

        public String toString() {
            return s;
        }
    }
}
