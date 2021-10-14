package com.luoxiaobatman.assignment.designpattern.structure;


/**
 * 意图: 独立抽象和实现, 已使他们都能独立的变化. 关键在于识别独立变化的维度
 * <p>别名: handle</p>
 * <p>
 * 适用范围:
 * <ul>
 *     <li></li>
 * </ul>
 * 效果:
 * <ul>
 *     <li></li>
 * </ul>
 */
public class PatternBridge {
    /**
     * 客户想使用的接口
     * 改动接口, 改动子类, 均不影响独立维度.
     */
    interface House {
        void live();
        void sell();  // 1. 添加不影响furniture和tv
    }

    public abstract class AbstractHouse implements House {
        private HouseAdditiveFurniture furniture;
        private HouseAdditiveTV tv;

        @Override
        public void live() {
            // impl
        }
    }

    abstract class RedefinedAbstractHouse extends AbstractHouse {
        @Override
        public void sell() { }
    }

    /**
     * 独立维度
     */
    interface HouseAdditiveFurniture {

    }

    abstract class AbstractHouseAdditiveFurniture implements HouseAdditiveFurniture {}

    class ConcreteFurniture extends AbstractHouseAdditiveFurniture {}

    /**
     * 独立维度
     */
    interface HouseAdditiveTV {

    }

    abstract class AbstractHouseAdditiveTV {

    }

    class ConcreteTV extends AbstractHouseAdditiveTV {

    }
}
