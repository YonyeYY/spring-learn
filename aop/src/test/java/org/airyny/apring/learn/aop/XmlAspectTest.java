package org.airyny.apring.learn.aop;

import org.airyny.spring.learn.aop.xmlaspect.facade.RoleService;
import org.airyny.spring.learn.aop.xmlaspect.model.Role;
import org.airyny.spring.learn.aop.xmlaspect.verifier.RoleVerifier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 16:25
 * @Version:1.0
 * @deseription:
 **/
public class XmlAspectTest {

    @Test
    public void test1(){
        //使用XML 使用ClassPathXmlApplicationContext 作为IoC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-xml-aspect.xml");

        RoleService roleService = context.getBean(RoleService.class);

        Role role = new Role();
        role.setName("Jun");
        role.setNote("this note");
        role.setSex("555");
        roleService.printRole(role);

        //引用
        RoleVerifier roleVerifier = (RoleVerifier)roleService;
        roleVerifier.roleVerifier(role);
    }


}
