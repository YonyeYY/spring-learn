package org.airyny.spring.learn.aop.aspect;

import org.airyny.spring.learn.aop.aspect.facade.RoleService;
import org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/15 11:14
 * @Version:1.0
 * @deseription: java 类方法配置
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.airyny.spring.learn.aop.aspect")
public class AopConfig {
    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }

    @Bean
    public RoleService getRoleService(){
        return new RoleServiceImpl();
    }

}

