package org.airyny.spring.learn.dynamic.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:00
 * @Version:1.0
 * @deseription:
 **/
public interface Interceptor {

    /*
     * @method: before
     * @Author: xiang.yongye
     * 
     * before 方法返回boolean 值，它在真实对象前调用。当返回为true 时，则反射真实
     * 对象方法；当返回为false 时，则调用around 方法。
     *
     * @param proxy 代理对象
     * @param target    真实对象
     * @param method    方法
     * @param args  运行方法参数
     * @return boolean 
     * @exception null
     */
    boolean before(Object proxy, Object target, Method method, Object[] args);
    
    /*
     * @method: around
     * @Author: xiang.yongye
     * 在反射真实对象方法或者around 方法执行之后，调用after 方法
     * @param proxy 代理对象
     * @param target    真实对象
     * @param method    方法
     * @param args  运行方法参数
     * @exception null
     */
    void around(Object proxy,Object target,Method method,Object[] args);

    /*
     * @method: after
     * @Author: xiang.yongye
     * 在反射真实对象方法或者在round 方法执行之后，调用after 方法
     * @param proxy 代理对象
     * @param target    真实对象
     * @param method    方法
     * @param args  运行方法参数
     * @exception null
     */
    void after(Object proxy,Object target,Method method,Object[] args);


}
