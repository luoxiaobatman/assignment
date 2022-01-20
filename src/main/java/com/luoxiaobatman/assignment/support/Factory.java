package com.luoxiaobatman.assignment.support;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 抽象工厂接口
 * @see #of(Class) 实例化工厂, 该工厂生产实例为Class
 * @see #newInstance(Object...)
 * @see #newInstance(Class, Object...)
 *
 * @param <IF> 生产的类实现的接口
 */
public interface Factory<IF> {
    <T extends IF> IF newInstance(Class<T> clazz, Object... args);
    default IF newInstance(Object... args) {
        return newInstance(null, args);
    };

    @SuppressWarnings("unchecked")
    static <F extends Factory<?>> F factory(Class<F> factoryClazz, Object... args) {
        // TODO check subclass of Factory
        try {
            return (F) factoryClazz.getConstructors()[0].newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }

    @SuppressWarnings("unchecked")
    static <IF> Factory<IF> of(Class<IF> iType) {
        Default aDefault = iType.getAnnotation(Default.class);
        assert  aDefault != null;
        Class<? extends IF> cType = (Class<? extends IF>) aDefault.value();
        return Factory.of(iType, cType);
    }

    @SuppressWarnings("unchecked")
    static <IF> Factory<IF> of(Class<IF> iType, Class<? extends IF> cType) {
        Invoker invoker = cType.getAnnotation(Invoker.class);
        if (invoker == null) {
            invoker = iType.getAnnotation(Invoker.class);
        }
        if (invoker != null) {
            return Factory.of(iType, cType, invoker.value());
        }
        return Factory.of(iType, cType, DefaultInvocationHandler.class);
    }

    static <IF> Factory<IF> of(Class<IF> iType, Class<? extends IF> cType, Class<? extends InvocationHandler> typeInvocationHandler) {
        assert iType.isInterface();
        return new StandardFactory<>(iType, cType);
    }
}
