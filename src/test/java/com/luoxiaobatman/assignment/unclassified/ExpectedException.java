package com.luoxiaobatman.assignment.unclassified;

public class ExpectedException extends RuntimeException {
    public ExpectedException(String message) {
        super(message);
    }
    public static final String REORDER = "reorder";
    public static final String LONG_IS_NOT_ATOMIC = "long_is_not_atomic";
//    public static final String LONG_IS_NOT_ATOMIC = "long_is_not_atomic";
}
