package org.airyny.spring.learn.mybatis.pub.biz;

import org.airyny.spring.learn.mybatis.pub.dao.dev.SysUserinfoMapper;
import org.airyny.spring.learn.mybatis.pub.model.dev.SysUserinfo;
import org.airyny.spring.learn.mybatis.pub.model.dev.SysUserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 17:23
 * @Version:1.0
 * @deseription:
 **/
@Service("sysUserinfoBiz")
public class SysUserinfoBiz {

    @Autowired
    SysUserinfoMapper sysUserinfoMapper;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<SysUserinfo> getList(){

        return sysUserinfoMapper.selectByExample(new SysUserinfoExample());
    }
}
