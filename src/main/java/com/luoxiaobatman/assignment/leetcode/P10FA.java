package com.luoxiaobatman.assignment.leetcode;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 题意理解错误
 */
@AllArgsConstructor
public class P10FA
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final String s;
    private final String p;

    @Override
    public Integer doSolve() {
        if (isMatch(s, p)) {
            return 1;
        }
        return 0;
    }

    public boolean isMatch(String s, String p) {
        if (s.length() < p.length()) return false;

        int i = 0;
        for (; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                break;
            } else {
                if (c != '.' && c != s.charAt(i)) {
                    return false;
                }
            }
        }
        s = s.substring(i);
        p = p.substring(i);

        i = 0;
        for (; i < p.length(); i++) {
            char c = p.charAt(p.length() - 1 - i);
            if (c == '*') {
                break;
            } else {
                if (c != '.' && c != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
        }
        s = s.substring(0, s.length() - i);
        p = p.substring(0, p.length() - i);
        if (p.isEmpty() && !s.isEmpty()) {
            return false;
        }

        List<String> tokens = tokenize(p);
        int idx = 0;
        for (String token : tokens) {
            idx = match(s, token, idx);
            if (idx == -1) {
                return false;
            }
        }
        return true;
    }

    private int match(String s, String token, int idx) {
        int j = idx;
        try {
            for (int i = 0; i < token.length(); i++, j++) {
                if (token.charAt(i) != '.') {
                    if (token.charAt(i) != s.charAt(j)) {
                        return -1;
                    }
                }
            }
        } catch (Exception e) {
            return -1;
        }
        return idx + token.length() + 1;
    }

    private List<String> tokenize(String p) {
        List<String> result = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                token.append(p.charAt(i));
            } else {
                if (!token.isEmpty()) {
                    result.add(token.toString());
                    token = new StringBuilder();
                }
            }
        }
        if (!token.isEmpty()) {
            result.add(token.toString());
        }
        return result;
    }
}
