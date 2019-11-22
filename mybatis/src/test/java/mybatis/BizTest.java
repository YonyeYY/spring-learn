package mybatis;

import org.airyny.spring.learn.mybatis.pub.biz.SysUserinfoBiz;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 17:21
 * @Version:1.0
 * @deseription:
 **/
public class BizTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");


    @Test
    public void bizTest(){
        SysUserinfoBiz sysUserinfoBiz = context.getBean("sysUserinfoBiz",SysUserinfoBiz.class);
        System.out.println(sysUserinfoBiz.getList().toString());
    }
}
