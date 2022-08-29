package com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage;

/**
 * 继承自RuntimeException, 需要global拦截器统一拦截
 */
public class InvalidStorageAmountException extends RuntimeException{
    public InvalidStorageAmountException(String message) {
        super(message);
    }
}
