package com.luoxiaobatman.assignment.tbc.cipher;

import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AESExpTest {
    @Test
    public void test() {
        Assertions.assertDoesNotThrow(() -> {
            Solver.solve(AESExp.class);
        });
    }
}
