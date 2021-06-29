package org.airyny.sync;

import com.alibaba.dubbo.common.utils.NamedThreadFactory;

import java.util.concurrent.*;

public class SyncExample {

    public static void doSomethingA(){

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("------doSomethingA-----");
    }

    public static void doSomethingB(){

        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("------doSomethingB-----");
    }

    public static void asyncMain(){
        long start = System.currentTimeMillis();

        //1、执行任务A
        doSomethingA();

        //2、执行任务B
        doSomethingB();

        System.out.println(System.currentTimeMillis()-start);
    }


    /**
     * 使用lambda 表达式创建一个Java.lang.Runnable 接口的匿名实现类，用来一部执行doSomethingA 任务，
     * 然后将其作为Thread 的参数并启动。这时候线程A与main 线程并发运行，也就是任务doSomethingA 与任务doSomeingB 并发运行，
     * thread.join()则是等main线程运行完doSomethingB 任务后同步等待线程A 运行完毕
     * @throws Exception
     */
    public static void syncRunnableMain()throws Exception{
        long start = System.currentTimeMillis();

        //1、开启一部单元执行执行任务A
        Thread thread = new Thread(()->{
            try{
                doSomethingA();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"threadA");

        thread.start();


        //2、执行任务B
        doSomethingB();

        //3、同步等待线程A 运行结束
        thread.join();
        System.out.println(System.currentTimeMillis()-start);
    }


    /**
     * 实现Thread 类 并重写run 方法
     * @throws Exception
     */
    public static void syncNewThreadMain()throws Exception{
        long start = System.currentTimeMillis();

        //1、开启一部单元执行执行任务A
        Thread thread = new Thread("NEW THREAD A"){
            @Override
            public void run(){
                try{
                    doSomethingA();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        };

        System.out.println("Thread name :"+thread.getName());
        thread.start();


        //2、执行任务B
        doSomethingB();

        //3、同步等待线程A 运行结束
        thread.join();
        System.out.println(System.currentTimeMillis()-start);
    }

    //自定义线程池
    //Runtime.getRuntime().availableProcessors() 获取当前物理机的CPU 核数
    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    /**
     * 创建线程池
     * 核心线程数为当前物理机CPU 核数
     * 最大线程个数为当前物理机CPU 核数的2 倍
     * 设置线程池阻塞队列的大小为5
     * 线程池的拒绝策略设置为CallerRunsPolicy，即当线程池任务饱和，执行拒绝策略时不会丢弃新的任务
     * 而是会使用调用线程来执行
     */
    private final static ThreadPoolExecutor POLL_EXECUTOR =
            new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
                    AVALIABLE_PROCESSORS * 2,
                    1,
                    TimeUnit.MINUTES,
                    new LinkedBlockingQueue <>(5),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    public static void syncPoolExecutorMain()throws Exception{
        long start = System.currentTimeMillis();

        //开启异步单元执行任务A
        POLL_EXECUTOR.execute(()->{
            try{
                doSomethingA();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        //执行任务B
        doSomethingB();

        System.out.println(System.currentTimeMillis()-start);

        //挂起当前线程
        Thread.currentThread().join();
    }

    public static void syncPoolExecutorMainb()throws Exception{
        long start = System.currentTimeMillis();

        //开启异步单元执行任务A
        POLL_EXECUTOR.execute(()->{
            try{
                doSomethingA();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        //开启异步单元执行任务B
        POLL_EXECUTOR.execute(()->{
            try{
                doSomethingB();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        System.out.println(System.currentTimeMillis()-start);

        //挂起当前线程
        Thread.currentThread().join();
    }



    //自定义线程池
    //Runtime.getRuntime().availableProcessors() 获取当前物理机的CPU 核数
    private final static int AVALIABLE_PROCESSORS_B = Runtime.getRuntime().availableProcessors();

    /**
     * 创建线程池
     * 核心线程数为当前物理机CPU 核数
     * 最大线程个数为当前物理机CPU 核数的2 倍
     * 设置线程池阻塞队列的大小为5
     * 线程池的拒绝策略设置为CallerRunsPolicy，即当线程池任务饱和，执行拒绝策略时不会丢弃新的任务
     * 而是会使用调用线程来执行
     */
    private final static ThreadPoolExecutor POLL_EXECUTOR_CALLABLE =
            new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
                    AVALIABLE_PROCESSORS * 2,
                    1,
                    TimeUnit.MINUTES,
                    new LinkedBlockingQueue <>(5),
                    new NamedThreadFactory("ASYNC-POOL"),
                    new ThreadPoolExecutor.CallerRunsPolicy());



    public static String sayHello(){

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("******* say hello *****");

        return "hello";

    }

    public static String sayHi(){

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("******* say hi *****");

        return "hi";

    }

    public static void syncCallableMain()throws Exception {

        //开启异步单元执行任务A
        Future<?> future = POLL_EXECUTOR_CALLABLE.submit(()->sayHello());


        Future<?> future2 = POLL_EXECUTOR_CALLABLE.submit(()->doSomethingB());

        //同步等待执行结果
        System.out.println(future.get());
    }


    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits

    //高3位： 1110 0000  0000 0000  0000 0000  0000 0000
    //接收新任务并且处理阻塞队列里的任务
    private static final int RUNNING    = -1 << COUNT_BITS;

    //高3位： 0000 0000  0000 0000  0000 0000  0000 0000
    //拒绝新任务但是处理阻塞队列里的任务
    private static final int SHUTDOWN   =  0 << COUNT_BITS;

    //高3位： 0010 0000  0000 0000  0000 0000  0000 0000
    //拒绝新任务并且抛弃阻塞队列里的任务，同时中断正在处理的任务
    private static final int STOP       =  1 << COUNT_BITS;

    //高3位： 0100 0000  0000 0000  0000 0000  0000 0000
    //所有任务都执行完（包含阻塞队列里面任务），当前线程池活动线程为0，将要调用terminated方法
    private static final int TIDYING    =  2 << COUNT_BITS;

    //高3位： 0110 0000  0000 0000  0000 0000  0000 0000
    //终止状态，terminated 方法调用完成以后的状态
    private static final int TERMINATED =  3 << COUNT_BITS;


    public static void syncFutureTaskMain()throws Exception{

        long start = System.currentTimeMillis();

        //创建future 任务
        FutureTask<String> futureTask = new FutureTask<String>(()->{
            String result = null;

            try{
                result = sayHello();
            }catch (Exception e){
                e.printStackTrace();
            }

            return result;

        });

        //开启异步单元执行任务A
        Thread thread = new Thread(futureTask, "threadA");
        thread.start();

        //执行任务B
        String taskBResult = sayHi();

        //同步等待线程A运行结束
        String taskAResult = futureTask.get();

        //打印两个任务执行结果
        System.out.println(taskAResult + " " + taskBResult);

        System.out.println(System.currentTimeMillis() - start);


    }
    private final static ThreadPoolExecutor POOL_EXECUTOR_CALLABLE =
            new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
                    AVALIABLE_PROCESSORS * 2,
                    1,
                    TimeUnit.MINUTES,
                    new LinkedBlockingQueue <>(5),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    public static void syncFutureTaskForPoolMain()throws Exception{

        long start = System.currentTimeMillis();

        //创建future 任务
        FutureTask<String> futureTask = new FutureTask<String>(()->{
            String result = null;

            try{
                result = sayHello();
            }catch (Exception e){
                e.printStackTrace();
            }

            return result;

        });

        FutureTask<String> futureTaska = new FutureTask<String>(()->{
            String result = null;

            try{
                System.out.println("==============");
                result = sayHello();
            }catch (Exception e){
                e.printStackTrace();
            }

        },null);

        //开启异步单元执行任务A
        POOL_EXECUTOR_CALLABLE.execute(futureTaska);

        POOL_EXECUTOR_CALLABLE.execute(futureTask);

        //执行任务B
        String taskBResult = sayHi();

        //同步等待线程A运行结束
        String taskAResult = futureTask.get();

        //打印两个任务执行结果
        System.out.println(taskAResult + " " + taskBResult);

        System.out.println(System.currentTimeMillis() - start);


    }
    public static void main(String[] args)throws Exception{

        syncFutureTaskForPoolMain();
//        System.out.println(Integer.toBinaryString(-2));
//        System.out.println(Integer.toBinaryString(-1));
//
//        System.out.println(Integer.toBinaryString(RUNNING));
        //asyncMain();


        //syncRunnableMain();

        //syncNewThreadMain();
//        syncCallableMain();
//
//        System.out.println(Runtime.getRuntime().availableProcessors());
//
//        syncPoolExecutorMain();
    }

}
