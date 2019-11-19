package org.airyny.apring.learn.aop;

import org.airyny.spring.learn.aop.game.facade.RoleService;
import org.airyny.spring.learn.aop.game.model.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/19 11:13
 * @Version:1.0
 * @deseription:
 **/
public class ClassicalTest {
    @Test
    public void test2(){
        //使用XML 使用ClassPathXmlApplicationContext 作为IoC 容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/spring-classical-config.xml");

        RoleService roleService = (RoleService)context.getBean("roleService");

        Role role = new Role();
        role.setName("Jun");
        role.setNote("this note");
        roleService.printRole(role);
    }

}
