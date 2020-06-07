package mybatis;

import org.airyny.spring.learn.mybatis.pub.biz.UserTransactionTest;
import org.airyny.spring.learn.mybatis.pub.faced.UserTransactionTestServicve;
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
        UserTransactionTestServicve sysUserinfoBiz = context.getBean("userTransactionTestServicve", UserTransactionTest.class);
        System.out.println(sysUserinfoBiz.getList());
    }

}
