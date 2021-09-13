package com.luoxiaobatman.assignment.ant;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MyInvocationHandler implements InvocationHandler {
    private final Object target;
//    private final Map<String, Method> declearedMethod;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO, 处理各种各样的annotation
        return method.invoke(this.target, args);
    }
}
