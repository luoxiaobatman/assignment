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

    /**
     *
     * @param factoryClazz
     * @param args Cons
     * @param <F> FactoryImpl
     * @return an instance of Factory
     */
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
        Invoker invoker = iType.getAnnotation(Invoker.class);
        if (invoker != null) {
            return Factory.of(iType, invoker.value());
        }
        return Factory.of(iType, DefaultInvocationHandler.class);
    }

    /**
     * @param iType
     * @param typeInvocationHandler proxy handler
     * @param <IF> interface you want to create
     * @return an instance of Factory
     */
    @SuppressWarnings("unchecked")
    static <IF> Factory<IF> of(Class<IF> iType, Class<? extends InvocationHandler> typeInvocationHandler) {
        assert iType.isInterface();

        return new Factory<>() {
            @Override
            public <T extends IF> T newInstance(Class<T> clazz, Object... args) {
                if (clazz == null) {
                    Default aDefault = iType.getAnnotation(Default.class);
                    if (aDefault != null) {
                        clazz = (Class<T>) aDefault.value();
                    } else {
                        throw new NullPointerException("clazz is null and interface has no Default implementation");
                    }
                }
                try {
                    Class<?>[] classes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
                    // TODO getConstructor 的方式
                    Object instance = clazz.getConstructors()[0].newInstance(args);
                    InvocationHandler invocationHandler = (InvocationHandler) typeInvocationHandler.getConstructors()[0].newInstance(instance);
                    return (T) Proxy.newProxyInstance(
                            clazz.getClassLoader(),
                            new Class[] {iType},
                            invocationHandler
                    );
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException();
                }
            }
        };
    }

    <T extends IF> IF newInstance(Class<T> clazz, Object... args);
    default <T extends IF> IF newInstance(Object... args) {
        return newInstance(null, args);
    };
}
