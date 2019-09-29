package org.airyny.spring.learn.dynamic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 9:47
 * @Version:1.0
 * @deseription:
 **/
public class JdkProxyExample implements InvocationHandler {

    private Object target = null;


    /*
     * @method: bind
     * @Author: xiang.yongye
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target 真实对象
     * @return java.lang.Object 代理对象
     * @exception null
     */
    public Object bind(Object target){
        this.target = target;
        /*
        *参数1：类加载器，我们采用了target本身的类加载器
        * 参数2：把生成的动态代理对象下挂在哪些接口下，这个写法就是放在terget实现的接口下。
        * HelloWorldImpl 对象的解耦显然就是 HelloWorld，代理对象可以这样声明：HelloWorld proxy =xxxx
        * 参数3：定义实现方法逻辑的代理类，this 表示当前对象，它必须实现InvocationHandler 接口的invoke 方法，
        * 它就是代理逻辑方法的实现方法
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /*
     * @method: invoke
     * @Author: xiang.yongye
     * 代理方法逻辑
     * @param proxy 代理对象，就是bind 方法生成的对象。
     * @param method    当前调度的方法
     * @param args  调度方法的参数
     * @return java.lang.Object
     * @exception null
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj =new Object();

        //判断该方法是否为sayHello()
        if (method.getName().equals("sayHello")){
            System.out.println("进入代理逻辑方法");
            System.out.println("在调度真实对象之前的服务");

            System.err.println("这是sayHello 方法");
            method.invoke(target,args);
            System.out.println("在调度真实对象之后的服务");
        }else{
            //相当于调用原方法
            obj = method.invoke(target,args);
        }

        return obj;
    }
}
