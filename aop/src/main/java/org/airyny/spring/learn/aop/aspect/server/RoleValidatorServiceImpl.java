package org.airyny.spring.learn.aop.aspect.server;

import org.airyny.spring.learn.aop.aspect.facade.RoleValidatorService;
import org.airyny.spring.learn.aop.aspect.model.Role;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 15:18
 * @Version:1.0
 * @deseription:
 **/
public class RoleValidatorServiceImpl implements RoleValidatorService {

    @Override
    public String validate(Role role) {
        System.out.println(role!=null?"role is null":"role is not null");
        return role!=null?"role is null":"role is not null";
    }
}
