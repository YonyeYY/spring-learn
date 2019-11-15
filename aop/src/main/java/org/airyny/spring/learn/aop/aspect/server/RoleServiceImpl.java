package org.airyny.spring.learn.aop.aspect.server;

import org.airyny.spring.learn.aop.aspect.facade.RoleService;
import org.airyny.spring.learn.aop.aspect.model.Role;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/15 10:56
 * @Version:1.0
 * @deseription:
 **/
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println(role.toString());

    }
}
