package com.luoxiaobatman.assignment.blackbox;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 使用cglib, 不断生成新的类, 放进元空间
 * <p>
 * < 1.7
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * >= 1.8
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class PermGenOOM {
    static class OOM {
    }

    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
                return proxy.invokeSuper(obj, args);
            });
            enhancer.create();
        }
    }
}
