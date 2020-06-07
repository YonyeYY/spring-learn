package org.airyny.spring.learn.mybatis.pub.biz;

import org.airyny.spring.learn.mybatis.pub.faced.SysUserinfoService;
import org.airyny.spring.learn.mybatis.pub.faced.UserTransactionTestServicve;
import org.airyny.spring.learn.mybatis.pub.model.dev.SysUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiang.yongye
 * @title: UserTransactionTest
 * @description: TODO
 * @date 2020/3/13  10:13
 */
@Service("userTransactionTestServicve")
public class UserTransactionTest implements UserTransactionTestServicve {
    @Autowired
    private SysUserinfoService sysUserinfoService;

    public String getList(){
        return sysUserinfoService.getList().toString();
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void insertRequried() {
        SysUserinfo sysUserinfo1 = new SysUserinfo();
        SysUserinfo sysUserinfo2 = new SysUserinfo();
        sysUserinfo1.setUserName("required1");
        sysUserinfo2.setUserName("required2");
        sysUserinfoService.insertRequired1(sysUserinfo1);
        sysUserinfoService.insertRequired2(sysUserinfo2);
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public void insertSupport() {
        SysUserinfo sysUserinfo1 = new SysUserinfo();
        SysUserinfo sysUserinfo2 = new SysUserinfo();
        sysUserinfo1.setUserName("Suppores1");
        sysUserinfo2.setUserName("Suppores2");
        sysUserinfoService.insertSuppores1(sysUserinfo1);
        sysUserinfoService.insertSuppores2(sysUserinfo2);
    }
}
