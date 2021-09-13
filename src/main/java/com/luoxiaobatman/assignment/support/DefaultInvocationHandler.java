package com.luoxiaobatman.assignment.support;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Cache annotation handle
 */
public class DefaultInvocationHandler implements InvocationHandler {
    private final Object target;
    private Object cache;
//    private final Map<String, Method> declearedMethod;

    public DefaultInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache annotation = method.getAnnotation(Cache.class);

        // TODO, 处理各种各样的annotation
        return method.invoke(this.target, args);
    }
}
