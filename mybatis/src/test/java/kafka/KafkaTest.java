package kafka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/24 11:24
 * @Version:1.0
 * @deseription:
 **/
public class KafkaTest {


    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");

        ((ClassPathXmlApplicationContext) context).start();

    }
}
