package com.luoxiaobatman.assignment.support;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class StandardFactory<IF> implements Factory<IF> {
    private final Class<IF> iType;
    private final Class<? extends IF> cType;

    public StandardFactory(Class iType) {
        this.iType = iType;
        this.cType = null;
    }

//    public StandardFactory(Class<IF> iType, Class<? extends IF> cType) {
    public StandardFactory(Class iType, Class cType) {
        this.iType = iType;
        this.cType = cType;
    }

    @Override
    public <T extends IF> IF newInstance(Class<T> clazz, Object... args) {
        if (clazz == null) {
            Default aDefault = iType.getAnnotation(Default.class);
            if (aDefault != null) {
                clazz = (Class<T>) aDefault.value();
            } else {
                clazz = (Class<T>) cType;
            }
        }
        assert clazz != null;
        try {
            Invoker invoker = clazz.getAnnotation(Invoker.class);
            if (invoker == null) {
                invoker = iType.getAnnotation(Invoker.class);
            }
            assert invoker != null;
            Class<? extends InvocationHandler> invocationHandlerType = invoker.value();
//                    Class<?>[] classes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
            // TODO getConstructor 的方式
            Object instance = clazz.getConstructors()[0].newInstance(args);
            InvocationHandler invocationHandler = (InvocationHandler) invocationHandlerType
                    .getConstructors()[0].newInstance(instance);
            return (IF) Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    new Class[]{iType},
                    invocationHandler
            );
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }
}
