package com.luoxiaobatman.assignment.support;

import org.junit.jupiter.api.Test;

/**
 * 测试 interface Factory 的of静态方法
 */
public class FactoryTest {
//    interface IDemo {
//        void doDemo();
//    }
//
//    public class DemoImpl implements IDemo {
//        @Override
//        public void doDemo() {
//            System.out.println("demo");
//        }
//
//        public DemoImpl() {}
//    }

    @Test
    public void testOf() {
        Factory<IDemo> demoFactory = Factory.of(IDemo.class);
        IDemo demo = demoFactory.newInstance(DemoImpl.class);
        demo.doDemo();
    }
}
