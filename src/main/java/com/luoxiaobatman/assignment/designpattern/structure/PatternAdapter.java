package com.luoxiaobatman.assignment.designpattern.structure;

/**
 * 意图: 将一个接口转换成另一个接口, 方便使用者
 * <p>别名: Wrapper</p>
 * <p>
 * 适用范围:
 * <ul>
 *     <li>想使用类, 但是它的接口不符合你的要求</li>
 *     <li>想创建类, 这个类可以和不相关不协同的位置类协同工作</li>
 *     <li>想使用子类, 但是不想对子类再子类化以匹配接口</li>
 * </ul>
 * 效果:
 * <ul>
 *     <li>不能匹配Adaptee的子类</li>
 *     <li>可重新定义adaptee行为</li>
 * </ul>
 * {@link PatternBridge}: 相似, 接口部分与实现部分分离
 * {@link PatternDecorator}: 接口的实现增加功能性, 透明, 递归
 * {@link PatternProxy}: Proxy具有相同的接口
 */
public class PatternAdapter {
    public interface TargetInterface {
        void request();
    }

    public interface Adaptee {
        void query();
    }

    public class ConcreteAdaptee implements Adaptee {
        @Override
        public void query() { }
    }

    public final class AdapterA implements TargetInterface, Adaptee {
        /**
         * 不是必须
         */
        private Adaptee adaptee;
        @Override
        public void request() {
            adaptee.query();
        }

        @Override
        public void query() {
            adaptee.query();
        }
    }

    /**
     * 想使用子类, 但是不想对子类再子类化以匹配接口
     */
    public final class AdapterB implements TargetInterface {
        private Adaptee adaptee;
        @Override
        public void request() {
            adaptee.query();
        }
    }
}
