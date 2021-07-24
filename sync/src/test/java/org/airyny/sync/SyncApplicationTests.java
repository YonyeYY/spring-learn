package org.airyny.sync;


import org.airyny.sync.service.AsyncExecutorExample;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class SyncApplicationTests {

    void contextLoads() {
    }

    public static void main(String[] args)throws Exception{
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-context.xml"}
        );

        System.out.println(Thread.currentThread().getName() + " begin");

        AsyncExecutorExample asyncExecutorExample = applicationContext.getBean(AsyncExecutorExample.class);

        asyncExecutorExample.printMessage();

        System.out.println(Thread.currentThread().getName()+" end");

        asyncExecutorExample.shutdown();
    }


    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();


    private final static ThreadPoolExecutor POLL_EXECUTOR =
            new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
                    AVALIABLE_PROCESSORS * 2,
                    10,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue <>(5),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main4(String[] args)throws Exception {

        List<String> stringList = new ArrayList<>();

        stringList.add("234");
        stringList.add("23422");

        System.out.println(stringList);


        for(int i=1; i<=5; i++){
            POLL_EXECUTOR.execute(()->{

                try{
                    Thread.sleep(2000);
                    System.out.println("==========");
                }catch (Exception e){
                    e.printStackTrace();
                }

            });
        }

        System.out.println("====END====");

    }

}
