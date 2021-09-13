package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.*;

/**
 * score=1
 *
 * 进阶 + 10: 设计编码 HashMap
 * 进阶 + 5: 编码并实现ArrayList
 * 进阶 ???: insert, remove不限次数
 *
 * <p>
 *     设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构
 *     insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
 *     remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
 *     getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
 * </p>
 * <p>
 *     最多进行 2 * 10**5 个insert, remove, getRandom
 * </p>
 */
public class P2134 implements Solution {
    public static class P2134Answer {
        private final Map<Integer, Integer> map = new HashMap<>(200000);
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
        answer.setAnswer(new P2134Answer());
        return answer;
    }
}
