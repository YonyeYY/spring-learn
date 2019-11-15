package org.airyny.spring.learn.aop.aspect;

import org.airyny.spring.learn.aop.aspect.facade.RoleService;
import org.airyny.spring.learn.aop.aspect.model.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/15 11:06
 * @Version:1.0
 * @deseription:
 **/
public class MainFunction {

    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        //使用XML 使用ClassPathXmlApplicationContext 作为IoC 容器
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");



        Role  role = new Role();
        role.setName("Jun");
        role.setNote("this not");
        role.setSex("555");
        RoleService roleService = ctx.getBean(RoleService.class);
        roleService.printRole(role);
    }
}
