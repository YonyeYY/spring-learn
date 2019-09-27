package org.airyny.spring.learn.aop.util;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.airyny.spring.learn.aop.interceptor.Interceptor;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 18:21
 * @Version:1.0
 * @deseription:
 **/
public class ProxyBeanUtil implements InvocationHandler {

    //被代理对象
    private Object obj;

    //拦截器
    private Interceptor interceptor = null;

    /*
     * @method: getBean
     * @Author: xiang.yongye
     * 获取动态代理对象
     * @param obj 被代理对象
     * @param interceptor  拦截器
     * @return java.lang.Object 动态代理对象
     * @exception null
     */
    public static Object getBean(Object obj, Interceptor interceptor){
        //使用当前类，作为代理方法，此时被代理对象执行方法的时候，会进入当前类的invoke方法里
        ProxyBeanUtil _this = new ProxyBeanUtil();

        //保存被代理对象
        _this.obj = obj;

        //保存拦截器
        _this.interceptor = interceptor;

        //生成代理对象，并绑定代理方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),_this);
    }


    /*
     * @method: invoke
     * @Author: xiang.yongye
     * 代理方法
     * @param  proxy    代理对象
     * @param method    当前调度方法
     * @param args  参数
     * @return java.lang.Object 方法返回
     * @exception null
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObj = null;
        //是否产生异常
        boolean exceptionFlag = false;
        //before 方法
        interceptor.before(obj);

        return null;
    }
}
