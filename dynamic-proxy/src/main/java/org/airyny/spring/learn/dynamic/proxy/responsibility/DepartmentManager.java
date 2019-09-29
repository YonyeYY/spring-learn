package org.airyny.spring.learn.dynamic.proxy.responsibility;

import java.lang.reflect.Method;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:51
 * @Version:1.0
 * @deseription:
 **/
public class DepartmentManager implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("部门经理审核前");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("部门经理===>>>>>>>>同意请假");

    }
}
