package com.luoxiaobatman.assignment.support.solution;

import com.luoxiaobatman.assignment.support.StandardFactory;

public class GenericSolutionFactory<T> extends StandardFactory<T> {
    private static GenericSolutionFactory<?> instance;
    /**
     * TODO luoxiao 调度bug
     */
    private static final ThreadLocal<Class<?>> local = new ThreadLocal<>();

    /**
     * 泛型千变万化
     * @param c 类型提示
     * @param <S> GenericAnswer<S>
     * @return 构造单例
     */
    @SuppressWarnings("unchecked")
    public static <S> GenericSolutionFactory<GenericSolution<S>> getInstance(
            Class<? extends GenericSolution<S>> c) {
        local.set(c);
        if (instance == null) {
            synchronized (GenericSolutionFactory.class) {
                if (instance == null) {
                    instance = new GenericSolutionFactory<>();
                }
            }
        }
        return (GenericSolutionFactory<GenericSolution<S>>) instance;
    }

    private GenericSolutionFactory() {
        super(GenericSolution.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T newInstance(Object... args) {
        return (T) super.newInstance((Class)local.get(), args);
    }
}
