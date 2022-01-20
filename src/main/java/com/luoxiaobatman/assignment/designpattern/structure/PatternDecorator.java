package com.luoxiaobatman.assignment.designpattern.structure;

import com.luoxiaobatman.assignment.support.Default;
import com.luoxiaobatman.assignment.support.DefaultInvocationHandler;
import com.luoxiaobatman.assignment.support.Factory;
import com.luoxiaobatman.assignment.support.Invoker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 装饰器
 * add functionality
 *
 * single responsibility principle
 *
 * 配合
 * @see java.lang.reflect.InvocationHandler
 * 实现控制反转, 即类声明时增加装饰器, 而非使用时增加装饰器
 */
public class PatternDecorator {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Functionnality {}

    @Default(Matrix.class)
    public interface IMatrix {
        void mul();
    }

    @Invoker(Decorator.class)
    public static class Matrix implements IMatrix {
        @Functionnality
        public void mul() {}
    }

    public static class Decorator extends DefaultInvocationHandler implements InvocationHandler {
        public Decorator(Object target) {
            super(target);
        }

        /**
         * 装饰器
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Functionnality annotation = method.getAnnotation(Functionnality.class);
            return method.invoke(getTarget(), args);
        }
    }

    public static void main(String[] args) {
        Factory<IMatrix> matrixFactory = Factory.of(IMatrix.class);
        IMatrix matrix = matrixFactory.newInstance();
        matrix.mul();
    }
}
