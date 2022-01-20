package com.luoxiaobatman.assignment.tbc.digest;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import java.util.zip.CRC32;


public class CRC32Exp extends AbstractSolution<Long> implements GenericSolution<Long> {
    @Override
    public Long doSolve() {
        CRC32 crc32 = new CRC32();
        crc32.update(123124);
        return crc32.getValue();
    }
}
