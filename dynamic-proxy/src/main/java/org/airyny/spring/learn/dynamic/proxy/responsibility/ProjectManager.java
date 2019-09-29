package org.airyny.spring.learn.dynamic.proxy.responsibility;

import java.lang.reflect.Method;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:50
 * @Version:1.0
 * @deseription:
 **/
public class ProjectManager implements Interceptor{
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("项目经理审核前");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("项目经理审核后----同意请假");
    }
}
