package org.airyny.apring.learn.aop;

import org.airyny.spring.learn.aop.aspect.AopConfig;
import org.airyny.spring.learn.aop.aspect.facade.RoleService;
import org.airyny.spring.learn.aop.aspect.facade.RoleValidatorService;
import org.airyny.spring.learn.aop.aspect.model.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/15 11:23
 * @Version:1.0
 * @deseription:
 **/
public class AspectTest {

    @Test
    public void test1(){
            ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
            //使用XML 使用ClassPathXmlApplicationContext 作为IoC 容器
            //ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");

        RoleService roleService = ctx.getBean(RoleService.class);

        RoleValidatorService roleValidatorService = (RoleValidatorService) roleService;
            Role role = new Role();
            role.setName("Jun");
            role.setNote("this not");
            role.setSex("555");
            roleService.printRole(role);
            roleValidatorService.validate(role);

    }
}
