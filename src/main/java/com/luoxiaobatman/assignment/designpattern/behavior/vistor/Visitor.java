package com.luoxiaobatman.assignment.designpattern.behavior.vistor;

import java.util.function.Consumer;

/**
 * first subject must accept your visitation then you can visit, that's common sense
 * <p>
 * 意图: 创造一系列相关或相互依赖的对象, 而无需指定他们的实现类
 * <p>
 * 适用范围:
 * <ul>
 *     <li>大规模规整, 重构项目, 需求已经非常清晰了</li>
 *     <li>类层次结构固定, 算法变动或算法增加</li>
 *     <li>不想让操作污染Consumer</li>
 * </ul>
 * 效果:
 * <ul>
 *     <li>易于增加新的操作</li>
 *     <li>集中相关操作, 分离无关操作</li>
 *     <li>增加新的ConcreteElement很困难</li>
 *     <li>访问者依赖了具体实现</li>
 *     <li>元素对访问者公布了细节</li>
 * </ul>
 */
public interface Visitor {
    /**
     * 访问者
     *
     * @param consumer ...
     */
    void visit(Consumer<Visitor> consumer);
}
