package org.airyny.spring.learn.dynamic.proxy.interceptor;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:34
 * @Version:1.0
 * @deseription:
 **/
public class InterceptorBiz implements InterceptorService{

    @Override
    public void agencyConnection() {
        System.out.println("conncetion: Interceptor_Agency");
    }
}
