package com.luoxiaobatman.assignment.designpattern.construct;

/**
 * 意图: 创造一系列相关或相互依赖的对象, 而无需指定他们的实现类
 * <p>
 * 适用范围:
 * <ul>
 *     <li>系统要独立于对象的创建, 组合, 或者表示</li>
 *     <li>系统要有多个对象中的一个来配置</li>
 *     <li>强调一系列对象的设计</li>
 *     <li>只想显示对象的接口而不是实现</li>
 * </ul>
 * 效果:
 * <ul>
 *     <li>对象的创造和实现分离</li>
 *     <li>使用不同的工厂即可创建接口的不同实现</li>
 *     <li>要创建新的接口, 要改变子类(通过语言特性可以避免, 或者extends接口的方式)</li>
 *     <li>只想显示对象的接口而不是实现</li>
 * </ul>
 * 工厂实例的创建:
 * 单例{@link PatternSingleton} 原型{@link PatternPrototype}
 */
public interface PatternAbstractFactory {
    /**
     * 利用反射的方式, 初始化工厂, 工厂一般是单例模式
     * @see PatternSingleton
     * @param type 工厂实现类
     * @return 工厂实例
     */
    static PatternAbstractFactory of(Class<? extends PatternAbstractFactory> type) {
        return null;
    }

    /**
     * 创建系列对象-1
     * @return 对象
     */
    AbstractProduct create();

    /**
     * 创建系列对象-2
     * @return 对象
     */
    AnotherAbstractProduct createAnother();

    /**
     * 一般用接口或者抽象类
     */
    interface AbstractProduct {}

    interface AnotherAbstractProduct {}

    class ConcreteFactory implements PatternAbstractFactory {
        @Override
        public AbstractProduct create() {
            return null;
        }

        @Override
        public AnotherAbstractProduct createAnother() {
            return null;
        }
    }
}
