package org.airyny.apring.learn.aop;

import org.airyny.spring.learn.aop.game.biz.RoleServiceImpl;
import org.airyny.spring.learn.aop.game.facade.RoleService;
import org.airyny.spring.learn.aop.game.interceptor.Interceptor;
import org.airyny.spring.learn.aop.game.interceptor.RoleInterceptor;
import org.airyny.spring.learn.aop.game.model.Role;
import org.airyny.spring.learn.aop.game.util.ProxyBeanFactory;

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
        RoleService proxy = (RoleService)ProxyBeanFactory.getBean(roleService,interceptor);
        Role role = new Role(1,"Jun","note");
        proxy.printRole(role);
        System.out.println("#################  测 试 afterthrowing 方 法 #############");
        role = null;
        proxy.printRole(role);
    }
}
