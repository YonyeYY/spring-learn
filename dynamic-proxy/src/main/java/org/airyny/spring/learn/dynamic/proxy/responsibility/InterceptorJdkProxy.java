package org.airyny.spring.learn.dynamic.proxy.responsibility;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:19
 * @Version:1.0
 * @deseription:
 **/
public class InterceptorJdkProxy implements InvocationHandler {

    //真实对象
    private Object target;

    //拦截器全限定名
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }


    /*
     * @method: bind
     * @Author: xiang.yongye
     * 绑定委托对象并返回一个【代理占位】
     * @param target    真实对象
     * @param interceptorClass  代理对象【占位】
     * @return java.lang.Object
     * @exception null
     */
    public static Object bind(Object target, String interceptorClass) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }


    /*
     * @method: invoke
     * @Author: xiang.yongye
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy     代理对象
     * @param method    方法，被调用方法
     * @param args      方法的参数
     * @return java.lang.Object
     * @exception null
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }
        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor =
                (Interceptor) Class.forName(interceptorClass).newInstance();

        //调用前置方法
        interceptor.before(proxy, target, method, args);

        result = method.invoke(target, args);

        //调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
