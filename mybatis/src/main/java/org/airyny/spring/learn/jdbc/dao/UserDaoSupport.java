package org.airyny.spring.learn.jdbc.dao;


import org.airyny.spring.learn.jdbc.model.SysUserinfo;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
//继承JdbcDaoSupport不需要再配置jdbcTemplate的bean，再父类中同时注入数据源
public class UserDaoSupport extends JdbcDaoSupport {


    public int insert(SysUserinfo sysUserinfo){
        String sql = "insert into sys_userinfo(id,user_name) values(?,?)";
        return getJdbcTemplate().update(sql,sysUserinfo.getId(),sysUserinfo.getUserName());
    }

    public int update(SysUserinfo sysUserinfo){
        String updateSql="update sys_userinfo u set u.user_name=?where id=?";
        return getJdbcTemplate().update(updateSql,sysUserinfo.getUserName(),sysUserinfo.getId());
    }

    public int delete(SysUserinfo sysUserinfo){
        String delSql="delete from sys_userinfo where id=?";
        return getJdbcTemplate().update(delSql,sysUserinfo.getId());
    }

    public List<SysUserinfo> findUsers(String userName){
        String sql = "select id,user_name,user_email from sys_userinfo where user_name like concat('%',?,'%')";
        Object[] params = {userName};
        List<SysUserinfo> list = getJdbcTemplate().query(sql,params,(ResultSet rs, int rowNum)->{
            SysUserinfo result = new SysUserinfo();
            result.setId(rs.getInt("id"));
            result.setUserName(rs.getString("user_name"));
            result.setUserEmail(rs.getString("user_email"));
            return result;
        });
        return list;
    }

}
