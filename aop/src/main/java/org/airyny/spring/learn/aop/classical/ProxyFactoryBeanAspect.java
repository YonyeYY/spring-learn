package org.airyny.spring.learn.aop.classical;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 17:32
 * @Version:1.0
 * @deseription:
 **/

public class ProxyFactoryBeanAspect implements MethodBeforeAdvice{

    /*
     * @method: before
     * @Author: xiang.yongye
     * 前置通知
     * @param method    被拦截方法（切点）
     * @param args      参数  数组[role]
     * @param target    被拦截对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知！！！");
    }
}
