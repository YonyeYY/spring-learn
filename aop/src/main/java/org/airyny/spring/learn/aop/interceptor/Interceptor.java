package org.airyny.spring.learn.aop.interceptor;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 17:48
 * @Version:1.0
 * @deseription:
 **/
public interface Interceptor {
    void before(Object obj);

    void after(Object obj);

    void afterReturning(Object obj);

    void afterThrowing(Object obj);

}
