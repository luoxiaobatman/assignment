package com.luoxiaobatman.assignment.interview.coding.epam;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * "123" + "110" = "233"
 */
@AllArgsConstructor
public class Plus
        extends AbstractSolution<String> implements GenericSolution<String> {
    private final String rawNumber1;
    private final String rawNumber2;

    private static final Map<String, Character> plusPreComputedMap = new HashMap<>();
    static {
//        plusPreComputedMap.put("0+9", '9');
    }

    @Override
    public String doSolve() {
        return plus(rawNumber1.trim(), rawNumber2.trim());
    }

    /**
     * We don't do negative ones.
     */
    private String plus(String operand1, String operand2) {
        if (operand1 == null || operand2 == null) return null;
        int length = Math.max(operand1.length(), operand2.length());
        char[] result = new char[length];
        int carry = 0;
        for (int i = length - 1; i > -1; i--) {
            int a = 0;
            int b = 0;
            try {
                a = operand1.charAt(i) - '0';
                if (a < 0 || a > 9) return null;
            } catch (IndexOutOfBoundsException ignored) {}
            try {
                b = operand2.charAt(i) - '0';
                if (b < 0 || b > 9) return null;
            } catch (IndexOutOfBoundsException ignored) {}
            int sum = a + b + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            result[i] = (char) (sum + '0');
        }
        if (carry == 0) return String.valueOf(result);
        return "1" + String.valueOf(result);
    }
}
