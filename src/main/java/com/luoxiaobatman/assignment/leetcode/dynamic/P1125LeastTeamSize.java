package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>问题描述</p>
 * 最小团队问题
 * 团队需要n种技能
 * 团队有m个人, 每个人会其中1-n个技能
 * 求凑齐这n种技能所需要的最小人数
 * n<=60
 * m<=16
 *
 * <p>评价</p>
 * leetcode hard
 * 实际评价 easy
 *
 * <p>解法</p>
 * <ul>
 *     <li>暴力方法2^m复杂度, 空间复杂度</li>
 *     <li>dp, 2^n * n, dp[i] 表示所需技能为i的最优解, 有不同的最优解没关系, 用一种技巧就可以很容易规避</li>
 * </ul>
 */
public class P1125LeastTeamSize implements Solution {
    private final int[] people;
    private final int[] skills;

    public P1125LeastTeamSize(String[] requiredSkills, String[][] providedPeople) {
        people = new int[providedPeople.length];
        List<String> skills = Arrays.stream(requiredSkills).collect(Collectors.toList());
        for (int i = 0; i < providedPeople.length; i++) {
            int peopleSkill = 0;
            for (int j = 0; j < providedPeople[i].length; j++) {
                peopleSkill |= 1 << skills.indexOf(providedPeople[i][j]);
            }
            people[i] = peopleSkill;
        }

        this.skills = new int[requiredSkills.length];
        for (int i = 0; i < requiredSkills.length; i++) {
            int mask = 1 << i;
            int maxPoint = 0;
            for (int j = 0; j < people.length; j++) {
                if ((people[j] & mask) > 0 && providedPeople[j].length > maxPoint) {
                    this.skills[i] = j;
                    maxPoint = providedPeople[j].length;
                }
            }
        }
    }

    @Override
    public Answer solve() {
        DP[] dp = new DP[1 << skills.length];
        DP dp0 = DP.of(0L, 0, 0);
        assert dp0 != null;
        dp[0] = dp0;

        // 复杂度 2^skills.length * skills.length
        for (int i = 0; i < skills.length; i++) {
            // j是技能二进制表示
            for (int j = (1 << i); j < (1 << i + 1); j++) {
                DP dpn = null;
                int personLen = (1 << 31) - 1;
                // k技能编号
                // skill[k]人员编号
                for (int k = 0; k < i + 1; k++) {
                    // k技能编号转换成二进制表示
                    int skill = 1 << k;
                    // j包含有技能编号k
                    if ((j & skill) != 0) {
                        // 找到上一个状态, dp的下标是j的k位取反
                        DP prev = dp[(~skill) & j];
                        int len;
                        if (!prev.skillExist(k)) {
                            len = prev.personLen() + 1;
                        } else {
                            len = prev.personLen();
                        }
                        if (len < personLen) {
                            personLen = len;
                            dpn = prev.copy();
                            if (len != prev.personLen()) {
                                dpn.addPersson(skills[k], people[skills[k]]);
                            }
                        }
                    }
                }
                dp[j] = dpn;
            }
        }

        return Factory.of(Answer.class).newInstance(dp[dp.length - 1].peopleIndexes());
    }

    /**
     * 动态规划的状态
     */
    private interface DP {
        static DP of(Object person, Object skill, int personLen) {
            if (person.getClass() == Long.class && skill.getClass() == Integer.class) {
                return new DP6432((Long) person, (Integer) skill, personLen);
            }
            return null;
        }

        int[] peopleIndexes();

        DP copy();

        boolean skillExist(int index);

        /**
         * @return 员工人数
         */
        int personLen();

        /**
         * 添加员工, 同时更新skill状态
         *
         * @param personIndex 员工编号
         * @param skill       技能
         */
        void addPersson(int personIndex, int skill);
    }

    /**
     * 64位人, 32位技能
     */
    private static class DP6432 implements DP {
        public long peopleState;
        public int skillState;
        public int personLen;

        public DP6432(long peopleState, int skillState, int personLen) {
            this.peopleState = peopleState;
            this.skillState = skillState;
            this.personLen = personLen;
        }

        @Override
        public int[] peopleIndexes() {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < 64; i++) {
                if (((1L << i) & peopleState) != 0) {
                    tmp.add(i);
                }
            }
            int[] result = new int[tmp.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = tmp.get(i);
            }
            return result;
        }

        @Override
        public DP copy() {
            return new DP6432(peopleState, skillState, personLen);
        }

        @Override
        public boolean skillExist(int index) {
            return (skillState & (1 << index)) != 0;
        }

        @Override
        public int personLen() {
            return personLen;
        }

        @Override
        public void addPersson(int personIndex, int skill) {
            peopleState |= (1L << personIndex);
            skillState |= skill;
            personLen++;
        }
    }

    /**
     * 32 + 32
     */
    private static class DP3232 {
        public int peopleState;
        public int skillState;
    }
}
