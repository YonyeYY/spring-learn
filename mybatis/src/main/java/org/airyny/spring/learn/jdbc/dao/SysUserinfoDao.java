package org.airyny.spring.learn.jdbc.dao;

import org.airyny.spring.learn.jdbc.model.SysUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/19 15:38
 * @Version:1.0
 * @deseription:
 **/
@Service
public class SysUserinfoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(SysUserinfo sysUserinfo){
        String sql = "insert into sys_userinfo(id,user_name) values(?,?)";
        return jdbcTemplate.update(sql,sysUserinfo.getId(),sysUserinfo.getUserName());
    }

    public int update(SysUserinfo sysUserinfo){
        String updateSql="update sys_userinfo u set u.user_name=?where id=?";
        return jdbcTemplate.update(updateSql,sysUserinfo.getUserName(),sysUserinfo.getId());
    }

    public int delete(SysUserinfo sysUserinfo){
        String delSql="delete from sys_userinfo where id=?";
        return jdbcTemplate.update(delSql,sysUserinfo.getId());
    }

    public List<SysUserinfo> findUsers(String userName){
        String sql = "select id,user_name,user_email from sys_userinfo where user_name like concat('%',?,'%')";
        Object[] params = {userName};
        List<SysUserinfo> list = jdbcTemplate.query(sql,params,(ResultSet rs, int rowNum)->{
            SysUserinfo result = new SysUserinfo();
            result.setId(rs.getInt("id"));
            result.setUserName(rs.getString("user_name"));
            result.setUserEmail(rs.getString("user_email"));
            return result;
        });
        return list;
    }
}
