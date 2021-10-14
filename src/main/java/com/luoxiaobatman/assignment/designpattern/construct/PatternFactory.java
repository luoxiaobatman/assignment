package com.luoxiaobatman.assignment.designpattern.construct;

/**
 * 意图: 定义一个方法, 返回一个对象, 让子类决定如何实现, 也可提供默认实现
 * <p>
 * 适用范围:
 * <ul>
 *     <li>当一个类不知道它需要创建的类的实现的时候</li>
 *     <li>子类代理者局部化</li>
 * </ul>
 * 效果:
 * <ul>
 *     <li>为子类提供一个钩子</li>
 *     <li>连接平行类</li>
 * </ul>
 */
public abstract class PatternFactory {
    interface Component {}

    public void publicMethod() {
        Component component = createComponent();
        // use component
    }

    /**
     * 子类提供实现, 也可提供一个默认实现
     * <ul>
     *     <li>作为一个钩子</li>
     *     <li>连接了平行类Component</li>
     * </ul>
     *
     * @return 对象
     */
    abstract Component createComponent();

    public final class ConcreteFactory extends PatternFactory {
        public final class ConcreteComponent implements Component {};

        @Override
        Component createComponent() {
            return new ConcreteComponent();
        }
    }
}
