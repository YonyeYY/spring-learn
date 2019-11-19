package org.airyny.spring.learn.aop.xmlaspect.server;

import org.airyny.spring.learn.aop.xmlaspect.facade.RoleService;
import org.airyny.spring.learn.aop.xmlaspect.model.Role;
import org.springframework.stereotype.Service;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 16:08
 * @Version:1.0
 * @deseription:
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role) {
        System.out.println(role.toString());
    }
}
