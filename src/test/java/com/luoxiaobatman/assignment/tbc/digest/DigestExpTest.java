package com.luoxiaobatman.assignment.tbc.digest;

import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigestExpTest {
    @Test
    public void test() {
        Assertions.assertDoesNotThrow(() -> {
            Solver.solve(CRC32Exp.class);
            Solver.solve(HmacExp.class);
            Solver.solve(MD5Exp.class);
            Solver.solve(Sha256Exp.class);
        });
    }
}
