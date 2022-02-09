package com.luoxiaobatman.assignment.datastructure.string;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.support.solution.Solver;
import lombok.AllArgsConstructor;

/**
 * 经典算法, 面试写不出来, 就去吃屎!
 */
@AllArgsConstructor
public class KMP extends AbstractSolution<Boolean> implements GenericSolution<Boolean> {
    /**
     * 模式串
     */
    private final String pattern;

    /**
     * 文本串
     */
    private final String text;

    @Override
    public Boolean doSolve() {
        if (pattern.length() > text.length()) return false;

        int[] patternTable = Solver.solve(KMPPatternBuilderFA.class, pattern);

        // 此刻, 模式串已经匹配成功的长度
        int matchedLength = 0;

        s: for (int i = 0; i < text.length(); i++) {
            if (matchedLength == pattern.length()) {
                break;
            }
            char patternNextCharToCompare = pattern.charAt(matchedLength);
            char textNextCharToCompare = text.charAt(i);
            if (textNextCharToCompare == patternNextCharToCompare) {
                matchedLength++;
            } else {
                while ((matchedLength = patternTable[matchedLength]) > -1) {
                    patternNextCharToCompare = pattern.charAt(matchedLength);
                    if (textNextCharToCompare == patternNextCharToCompare) {
                        matchedLength++;
                        continue s;
                    }
                }
                matchedLength = 0;
            }
        }
        return matchedLength == pattern.length();
    }
}
