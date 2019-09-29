package org.airyny.spring.learn.dynamic.proxy.cglib;


import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 10:27
 * @Version:1.0
 * @deseription:
 **/
public class CglibProxyExample implements MethodInterceptor {


    /*
     * @method: getProxy
     * @Author: xiang.yongye
     * 【生成CGLIB 代理对象】
     * 这里用了CGLIB 的加强者Enhancer，通过设置超类的方法（setSuperclass），然后通过
     * setCallback 方法设置哪个类为它的代理类。其中，参数为this就意味着是当前对象，那就要求用
     * this 这个对象实现接口MethodInterceptor 的方法------intercept，然后返回代理对象
     * @param cls ----Class 类
     * @return java.lang.Object 类的CGLIB 代理对象
     * @exception null
     */
    public Object getProxy(Class cls){
        //CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象当前对象，要求当前对象实现MethodInterceptor 方法
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        Object result = methodProxy.invokeSuper(proxy,args);
        System.err.println("调用真实对象后");
        return result;
    }
}
