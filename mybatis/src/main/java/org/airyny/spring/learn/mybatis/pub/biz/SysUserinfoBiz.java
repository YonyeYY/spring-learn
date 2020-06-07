package org.airyny.spring.learn.mybatis.pub.biz;

import org.airyny.spring.learn.mybatis.pub.dao.dev.SysUserinfoMapper;
import org.airyny.spring.learn.mybatis.pub.faced.SysUserinfoService;
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
@Service("sysUserinfoService")
public class SysUserinfoBiz implements SysUserinfoService {

    @Autowired
    SysUserinfoMapper sysUserinfoMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<SysUserinfo> getList(){

        return sysUserinfoMapper.selectByExample(new SysUserinfoExample());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertRequired1(SysUserinfo sysUserinfo){
        return sysUserinfoMapper.insert(sysUserinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertRequired2(SysUserinfo sysUserinfo){
        return sysUserinfoMapper.insert(sysUserinfo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public int insertSuppores1(SysUserinfo sysUserinfo){
        return sysUserinfoMapper.insert(sysUserinfo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public int insertSuppores2(SysUserinfo sysUserinfo){
        return sysUserinfoMapper.insert(sysUserinfo);
    }

}
