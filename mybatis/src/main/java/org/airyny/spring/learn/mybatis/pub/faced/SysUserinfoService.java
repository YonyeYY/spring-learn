package org.airyny.spring.learn.mybatis.pub.faced;

import org.airyny.spring.learn.mybatis.pub.model.dev.SysUserinfo;

import java.util.List;

/**
 * @author xiang.yongye
 * @title: SysUserinfoService
 * @description: TODO
 * @date 2020/3/13  10:21
 */
public interface SysUserinfoService {

    public List<SysUserinfo> getList();
    public int insertRequired1(SysUserinfo sysUserinfo);
    public int insertRequired2(SysUserinfo sysUserinfo);
    public int insertSuppores1(SysUserinfo sysUserinfo);
    public int insertSuppores2(SysUserinfo sysUserinfo);
}
