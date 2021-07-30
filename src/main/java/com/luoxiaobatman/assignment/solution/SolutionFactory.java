package com.luoxiaobatman.assignment.solution;

import com.luoxiaobatman.assignment.ant.MyInvocationHandler;
import com.luoxiaobatman.assignment.solution.Solution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class SolutionFactory {
    /**
     * naive!!!
     * @param c class
     * @param args constructor args
     * @return class instance
     */
    @SuppressWarnings("unchecked")
    public static <T extends Solution<?>> T get(Class<? extends Solution<?>> c, Object... args) {
        try {
            // TODO 根据args type 找到constructor, deadline赶时间, 这样写了
            return (T) Proxy.newProxyInstance(
                    c.getClassLoader(),
                    new Class[] {Solution.class},
                    new MyInvocationHandler(c.getConstructors()[0].newInstance(args))
            );
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            // naive
            throw new RuntimeException();
        }
    }
}
