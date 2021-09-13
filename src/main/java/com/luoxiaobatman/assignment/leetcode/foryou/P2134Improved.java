package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.Data;

import java.util.*;

/**
 * score=10
 *
 * 进阶 + 100: 通用型的HashMap
 * 进阶 ???: insert, remove不限次数
 *
 * <p>
 *     简易的HashMap
 * </p>
 * @see P2134
 */
public class P2134Improved implements Solution {
    /**
     * 线程不安全
     * 粗糙的实现
     */
    public static class IntHashMap {
        private Entry[] entries = new Entry[200000];
        @Data
        private static class Entry {
            private Integer key;
            private Integer value;
            private Entry next;
            private Entry prev;

            public String toString() {
                return key.toString();
            }

            public void link(Entry e) {
                if (this.equals(e)) {
                    this.prev.setNext(e);
                    e.setNext(this.getNext());
                } else if (this.getNext() == null) {
                    this.setNext(e);
                    e.setPrev(this);
                } else {
                    getNext().link(e);
                }
            }

            public void setNext(Entry e) {
                this.next = e;
                if (e != null) e.setPrev(this);
            }

            public Entry(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        boolean put(Integer key, Integer value) {
            Entry entry = new Entry(key, value);
            int hash = hash(key);
            Entry head = entries[hash];
            if (head == null) {
                entries[hash] = entry;
            } else if (head.equals(entry)) {
                entries[hash] = entry;
                entry.setNext(head.getNext());
            } else {
                head.link(entry);
            }
            return true;
        }

        public boolean containsKey(Integer key) {
            int hash = hash(key);
            Entry nextEntry = entries[hash];

            do {
                if (nextEntry == null) return false;
                if (nextEntry.getKey().equals(key)) return true;
            } while ((nextEntry = nextEntry.getNext()) != null);
            return false;
        }

        public Integer remove(Integer key) {
            int hash = hash(key);
            Entry current = entries[hash];
            if (current == null) {
                return null;
            } else if (current.getKey().equals(key)) {
                Entry next = current.getNext();
                if (next != null) {
                    next.setPrev(null);
                }
                entries[hash] = next;
                return current.getValue();
            } else {
                while ((current = current.getNext()) != null) {
                    if (current.getKey().equals(key)) return current.getValue();
                }
            }
            return null;
        }

        private int hash(Integer key) {
            // TODO shift效率更高
            return key % 200000;
        }
    }

    public static class P2134ImprovedAnswer {
        private final IntHashMap map = new IntHashMap();
        private final List<Integer> ints = new ArrayList<>(200000);

        public boolean insert(Integer i) {
            if (map.containsKey(i)) {
                return false;
            }
            ints.add(i);
            map.put(i, ints.size() - 1);
            return true;
        }
        public boolean remove(Integer i) {
            Integer index = map.remove(i);
            if (index != null) {
                ints.remove(index.intValue());
                return true;
            }
            return false;
        }
        public Integer getRandom() {
            int i = new Random().nextInt(ints.size());
            return ints.get(i);
        }
    }

    @Override
    public Answer solve() {
        Answer answer = Factory.of(Answer.class).newInstance();
        answer.setAnswer(new P2134ImprovedAnswer());
        return answer;
    }
}
