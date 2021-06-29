package org.airyny.sync;


import org.airyny.sync.service.AsyncExecutorExample;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SyncApplicationTests {

    void contextLoads() {
    }

    public static void main(String[] args)throws Exception{
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-context.xml"}
        );

        System.out.println(Thread.currentThread().getName() + " begin");

        AsyncExecutorExample asyncExecutorExample = applicationContext.getBean(AsyncExecutorExample.class);

        asyncExecutorExample.printMessage2();

        System.out.println(Thread.currentThread().getName()+" end");



    }
}
