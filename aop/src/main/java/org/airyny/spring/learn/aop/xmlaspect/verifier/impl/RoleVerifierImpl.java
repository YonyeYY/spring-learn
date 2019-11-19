package org.airyny.spring.learn.aop.xmlaspect.verifier.impl;

import org.airyny.spring.learn.aop.xmlaspect.model.Role;
import org.airyny.spring.learn.aop.xmlaspect.verifier.RoleVerifier;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 16:46
 * @Version:1.0
 * @deseription:
 **/
public class RoleVerifierImpl implements RoleVerifier {
    @Override
    public void roleVerifier(Role role) {
        System.out.println(role==null?"role is null":"role is not null");
    }
}
