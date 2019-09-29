package org.airyny.spring.learn.dynamic.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:17
 * @Version:1.0
 * @deseription:
 **/
public class MyInterceptor implements  Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");
    }
}
