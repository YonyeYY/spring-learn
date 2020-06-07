package transaction;

import org.airyny.spring.learn.mybatis.pub.faced.UserTransactionTestServicve;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiang.yongye
 * @title: TransactionTest
 * @description: TODO
 * @date 2020/3/13  10:32
 */
public class TransactionTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");


    @Test
    public void bizTest(){
        UserTransactionTestServicve userTransactionTestServicve = context.getBean("userTransactionTestServicve", UserTransactionTestServicve.class);
        userTransactionTestServicve.insertRequried();
    }

}
