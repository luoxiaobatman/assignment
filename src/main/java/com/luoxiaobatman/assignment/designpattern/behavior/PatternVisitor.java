package com.luoxiaobatman.assignment.designpattern.behavior;

/**
 * 意图: 创造一系列相关或相互依赖的对象, 而无需指定他们的实现类
 * <p>
 * 适用范围:
 * <ul>
 *     <li>大规模规整, 重构项目, 需求已经非常清晰了</li>
 *     <li>类层次结构固定, 算法变动或算法增加</li>
 *     <li>不想让操作污染Element</li>
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
public class PatternVisitor {
    /**
     * 相关操作在visitor中集中起来了
     * ConcreteElementA, ConcreteElementB等也可
     */
    interface Visitor {
        void visit(ConcreteElementA element);
        void visit(ConcreteElementB element);
    }

    /**
     * 相关操作的算法实现
     * 替换一种实现的话, 就是增加一个类
     */
    class ConcreteVisitor implements Visitor {
        @Override
        public void visit(ConcreteElementA element) {
        }
        @Override
        public void visit(ConcreteElementB element) {
        }
    }

    interface Element {
        void accept(Visitor visitor);
    }

    /**
     * 不必实现Element, 任何对象都可被访问
     */
    class ConcreteElementA implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /**
     * 不必实现Element, 任何对象都可被访问
     */
    class ConcreteElementB implements Element {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    class Client {
        private Element element;
        void accept(Visitor visitor) {
            element.accept(visitor);
        }
    }
}
