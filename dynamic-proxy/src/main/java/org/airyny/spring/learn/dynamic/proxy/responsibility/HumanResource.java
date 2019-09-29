package org.airyny.spring.learn.dynamic.proxy.responsibility;

import java.lang.reflect.Method;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:52
 * @Version:1.0
 * @deseription:
 **/
public class HumanResource implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("人事审核前");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("人事同意==>>>>>>>请假");
    }
}
