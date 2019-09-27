package org.airyny.apring.learn.aop;

import org.airyny.spring.learn.aop.biz.RoleServiceImpl;
import org.airyny.spring.learn.aop.facade.RoleService;
import org.airyny.spring.learn.aop.interceptor.Interceptor;
import org.airyny.spring.learn.aop.interceptor.RoleInterceptor;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 18:17
 * @Version:1.0
 * @deseription:
 **/
public class GameMain {
    public static void main(String[] args){
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();
        RoleService proxy = ProxyBean
    }
}
