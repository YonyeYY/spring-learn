package jdk;

import org.airyny.spring.learn.dynamic.proxy.jdk.HelloWorld;
import org.airyny.spring.learn.dynamic.proxy.jdk.HelloWorldImpl;
import org.airyny.spring.learn.dynamic.proxy.jdk.JdkProxyExample;
import org.junit.Test;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 9:53
 * @Version:1.0
 * @deseription:
 **/
public class JdkTest {
    @Test
    public void jdkTest(){
        JdkProxyExample jdk = new JdkProxyExample();
        //绑定关系，因为挂在接口HelloWorld下，所以声明代理对象HelloWorld Proxy
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
        //注意，此时HelloWorld 对象已经是一个代理对象，它会今若代理的逻辑方法invoke里
        proxy.sayHelloWorld();
        proxy.sayHello2();
        proxy.sayHello();
    }
    @Test
    public void test0(){
        System.out.println((String)null);

    }
}
