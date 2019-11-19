package jdbc;

import org.airyny.spring.learn.jdbc.dao.SysUserinfoDao;
import org.airyny.spring.learn.jdbc.dao.UserDaoSupport;
import org.airyny.spring.learn.jdbc.model.SysUserinfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/19 14:10
 * @Version:1.0
 * @deseription:
 **/
public class JdbcTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    SysUserinfoDao sysUserinfoDao = ctx.getBean("sysUserinfoDao",SysUserinfoDao.class);
    UserDaoSupport userDaoSupport = ctx.getBean("userDaoSupport", UserDaoSupport.class);


    @Test
    public void test(){
        Integer id = 1;
        String sql = "select id,user_id,user_name,user_email from sys_userinfo where id = " + id;
        SysUserinfo sysUserinfo = jdbcTemplate.queryForObject(sql, new RowMapper<SysUserinfo>() {
            @Override
            public SysUserinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysUserinfo sysUserinfo = new SysUserinfo();
                sysUserinfo.setId(rs.getInt("id"));
                sysUserinfo.setUserId(rs.getString("user_id"));
                sysUserinfo.setUserName(rs.getString("user_name"));
                sysUserinfo.setUserEmail(rs.getString("user_email"));
                return sysUserinfo;
            }
        });
        System.out.println(sysUserinfo.toString());
    }

    @Test
    public void testForLambda(){
        Integer id = 1;
        String sql = "select id,user_id,user_name,user_email from sys_userinfo where id = " + id;
        SysUserinfo result = jdbcTemplate.queryForObject(sql, (ResultSet rs,int rownum)->{
                SysUserinfo sysUserinfo = new SysUserinfo();
                sysUserinfo.setId(rs.getInt("id"));
                sysUserinfo.setUserId(rs.getString("user_id"));
                sysUserinfo.setUserName(rs.getString("user_name"));
                sysUserinfo.setUserEmail(rs.getString("user_email"));
                return sysUserinfo;

        });
        System.out.println(result.toString());
    }

    @Test
    public void testForDao(){
        SysUserinfo condition = new SysUserinfo();
        condition.setId(10);
        condition.setUserName("章鱼小丸子哇！！！");
        sysUserinfoDao.insert(condition);
    }

    @Test
    public void testForDaoUpdate(){
        SysUserinfo condition = new SysUserinfo();
        condition.setId(10);
        condition.setUserName("改了章鱼小丸子哇！！！");
        sysUserinfoDao.update(condition);
    }

    @Test
    public void testForDaoFindUsers(){
        List<SysUserinfo> list = sysUserinfoDao.findUsers("小丸子");
        System.out.println(list.toString());
    }

    @Test
    public void testForSupportFindUsers(){
        List<SysUserinfo> list = userDaoSupport.findUsers("小丸子");
        System.out.println(list.toString());
    }


}
