package org.airyny.spring.learn.aop.aspect.facade;

import org.airyny.spring.learn.aop.aspect.model.Role;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 15:15
 * @Version:1.0
 * @deseription:
 **/
public interface RoleValidatorService {

    String validate(Role role);
}
