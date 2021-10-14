package com.luoxiaobatman.assignment.designpattern.structure;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 意图: 共享以支持大量细粒度的对象
 * <p>
 * 适用范围:
 * <ul>
 *     <li>使用了大量的对象</li>
 *     <li>完全使用这些对象, 会造成很大的开销</li>
 *     <li>对象状态都可变为外部状态</li>
 *     <li>如果删除外部状态, 可以用较少的对象取代这些对象</li>
 * </ul>
 * 效果:
 * <ul>
 *     <li>减少内存占用</li>
 * </ul>
 *
 */
public class PatternFlyweight {
    abstract class Flyweight {
        /**
         * 内部状态
         */
        private String inState;

        public String getInState() {
            return inState;
        }

        public void setInState(String inState) {
            this.inState = inState;
        }

        /**
         * 外部状态
         */
        protected final String exState;

        protected Flyweight(String exState) {
            this.exState = exState;
        }

        public abstract void operation();
    }

    class ConcreteFlyweight extends Flyweight {
        protected ConcreteFlyweight(String exState) {
            super(exState);
        }

        @Override
        public void operation() {

        }
    }

    class FlyweightFactory {
        private Map<String, Flyweight> pool = new HashMap<>();
        public Flyweight get(String exState) {
            if (pool.containsKey(exState)) {
                return pool.get(exState);
            } else {
                ConcreteFlyweight flyweight = new ConcreteFlyweight(exState);
                pool.put(exState, flyweight);
                return flyweight;
            }
        }
    }
}
