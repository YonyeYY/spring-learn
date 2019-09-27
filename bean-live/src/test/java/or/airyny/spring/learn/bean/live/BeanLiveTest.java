package or.airyny.spring.learn.bean.live;

import org.airyny.spring.learn.bean.live.pojo.ConstructorBean;
import org.airyny.spring.learn.bean.live.pojo.JuiceMaker2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/26 20:03
 * @Version:1.0
 * @deseription:
 **/
public class BeanLiveTest {

    private static final Logger log = LogManager.getLogger(BeanLiveTest.class);

    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("spring/spring-bean-live-context.xml");

    @Test
    public void beanLiveTest() {
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) context.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
        context.close();
    }

    @Test
    public void iocTest() {

        ConstructorBean constructorBean = (ConstructorBean) context.getBean("constructorBean");
        System.out.println(constructorBean.getName());
        context.close();
    }
}
