package redis;

import org.airyny.spring.learn.mybatis.pub.server.SendRedis;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/22 18:00
 * @Version:1.0
 * @deseription:
 **/
public class RedisTest {

    SendRedis sendRedis;


    @Before
    public void setSendMessage(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");

        this.sendRedis = context.getBean("sendRedis",SendRedis.class);
    }


    @Test
    public void redis() {
        sendRedis.outPut();
    }
}
