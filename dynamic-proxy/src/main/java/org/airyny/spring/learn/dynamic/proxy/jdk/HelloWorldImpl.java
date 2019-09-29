package org.airyny.spring.learn.dynamic.proxy.jdk;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 9:45
 * @Version:1.0
 * @deseription:
 **/
public class HelloWorldImpl implements HelloWorld{
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void sayHello2() {
        System.out.println("Hello2");
    }
}
