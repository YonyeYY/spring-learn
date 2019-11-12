package kafka;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/24 11:24
 * @Version:1.0
 * @deseription:
 **/
public class KafkaTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");

    @Test
    public void start(){

        ((ClassPathXmlApplicationContext) context).start();

    }


}
