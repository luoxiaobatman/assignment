package com.luoxiaobatman.assignment.designpattern.construct;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 意图: 复杂对象的构建和他的表示分离
 * <p>
 * 适用范围:
 * <ul>
 *     <li>创建对象的算法独立于对象的组成以及(装配方式?)</li>
 *     <li>构造过程必须允许被构造的对象有不同的表示</li>
 * </ul>
 * 效果:
 * <ul>
 *     <li>改变一个产品的内部表示</li>
 *     <li>构造和表示分离</li>
 *     <li>精细控制构造过程</li>
 * </ul>
 */
public interface PatternBuilder {
    interface Product {};

    /**
     * buildPartA
     * buildPartB
     * etc...
     */
    void buildPart();
    Product result();

    /**
     * 定义不同的导演, builder模式更加灵活
     */
    @Data
    @AllArgsConstructor
    final class Director {
        private PatternBuilder builder;
        public void construct() {
            builder.buildPart();
        }
        public Product result() {
            return builder.result();
        }
    }
}
