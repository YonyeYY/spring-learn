package org.airyny.spring.learn.aop.game.util;

import org.airyny.spring.learn.aop.game.interceptor.Interceptor;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 19:35
 * @Version:1.0
 * @deseription:
 **/
public class ProxyBeanFactory {

    public static <T> T getBean(T obj,Interceptor interceptor){
        return (T) ProxyBeanUtil.getBean(obj,interceptor);
    }
}
