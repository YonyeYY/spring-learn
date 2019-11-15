package org.airyny.spring.learn.aop.game.biz;

import org.airyny.spring.learn.aop.game.facade.RoleService;
import org.airyny.spring.learn.aop.game.model.Role;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 18:11
 * @Version:1.0
 * @deseription:
 **/
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role) {
        System.out.println(role.toString());
    }
}
