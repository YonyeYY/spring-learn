package org.airyny.sync;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestCompletableFutureSet {

    //自定义线程池
    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(
            AVALIABLE_PROCESSORS,
            AVALIABLE_PROCESSORS * 2,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(5),
            new ThreadPoolExecutor.CallerRunsPolicy());


    //显式设置CompletableFuture 结果
    public static void completableForThreaPoolExecutorMain()throws Exception{

        //创建一个CompletableFuture 对象
        CompletableFuture<String> future = new CompletableFuture<String>();

        //开启线程计算任务结果，并设置
        POOL_EXECUTOR.execute(()->{

            //休眠3s，模拟任务计算
            try{
                Thread.sleep(3000);
            }catch (Exception e){

                e.printStackTrace();
            }

            //设置计算结果到future
            System.out.println("---------" + Thread.currentThread().getName() + "set future result---");


            //调用future 的complete 方法设置future 的结果，设置完结果后，
            // 所有由于调用future 的get()方法而被阻塞的线程会被激活，并返回设置的结果
            future.complete("hello,jiaduo");

        });

        //等待计算结果
        System.out.println("-----main thread wait future result---");

        //future 的get方法企图获取future 的结果，如果future 的结果没有被设置，则调用线程会被阻塞
        System.out.println(future.get());


        System.out.println("------main thread got future result-----");
    }


    /**
     * 基于runAsync 系列方法实现无返回值的异步计算：当你向异步执行一个任务，并且不需要任务的执行结果时可以使用该方法
     * 比如异步打日志，异步做消息通知等
     * @throws Exception
     */
    public static void runAsync()throws Exception{

        /**
         * 创建异步任务，并返回future
         * 由于runAsync 方法不会有返回值，所以当任务执行完毕后，设置future 的记过为null
         * 所以后面future.get()会返回null
         */
        CompletableFuture future = CompletableFuture.runAsync(new Runnable(){

            @Override
            public void run() {
                //休眠2s 模拟任务计算
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("over");
            }
        });

        /**
         * 在默认情况下，runAsync（Runnable runnable)方法是使用整个JVM 内唯一的Fork Join Pool.commonPool()线程池来执行异步任务的
         * 使用runAsync(Runnable runnable，Executor executor)方法允许我们使用自己制定的线程池来执行异步任务。
         *
         */
        CompletableFuture futureForPoolExecutor = CompletableFuture.runAsync(
                new Runnable(){

                    @Override
                    public void run() {
                        //休眠2s 模拟任务计算
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        System.out.println("futureForPoolExecutor");
                    }
                },
                POOL_EXECUTOR);

        //同步等待异步任务执行结束
        System.out.println(future.get());

        System.out.println(futureForPoolExecutor.get());


        if (null == future.get()){
            System.out.println("future.get() is null");
        }

        if (null == futureForPoolExecutor.get()){
            System.out.println("futureForPoolExecutor.get() is null");
        }
    }

    /**
     * 有返回值的异步执行
     * @throws Exception
     */
    public static void supplyAsync()throws Exception{

        /**
         * 创建异步任务，并返回future
         * 默认情况夏，supplyAsync(Supplier<U> supplier)方法是
         * 使用整个JVM 内唯一的ForkJoinPool.commonPool()线程池来执行异步任务的
         * 使用supplyAsync(Supplier<U> supplier, Executor executor)方法允许我们使用自己制定的线程池来执行异步任务
         */
        CompletableFuture futrue = CompletableFuture.supplyAsync(
                new Supplier<String>(){

                    @Override
                    public String get() {

                        //休眠2s 模拟任务计算
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }

                        //返回异步计算结果
                        return "hello,supplyAsync";
                    }
                }
        );


        /**
         * 创建异步任务，并返回future
         * 使用supplyAsync(Supplier<U> supplier, Executor executor)方法允许我们使用自己制定的线程池来执行异步任务
         */
        CompletableFuture futrueForBizPool = CompletableFuture.supplyAsync(
                new Supplier<String>(){

                    @Override
                    public String get() {

                        //休眠2s 模拟任务计算
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }

                        //返回异步计算结果
                        return "hello,futrueForBizPool";
                    }
                },
                POOL_EXECUTOR);

        /**
         * 同步等待异步任务执行结束
         * 调用线程会被阻塞，等异步任务把结果设置到future 后，调用线程就会从get()处返回异步任务执行的结果
         */
        System.out.println(futrue.get());


        /**
         * 同步等待异步任务执行结束
         * 调用线程会被阻塞，等异步任务把结果设置到future 后，调用线程就会从get()处返回异步任务执行的结果
         */
        System.out.println(futrueForBizPool.get());

    }

    /**
     * 基于thenRun实现异步任务A，执行完毕后，激活异步任务B执行，
     * 需要注意的是，这种方式激活的异步任务B是拿不到任务A的执行结果的：
     *
     * 默认情况下oneFuture 对应的异步任务和在oneFuture 上提娜佳的回调事件都是使用ForkJoinPool.commonPool()中的同一个线程来执行的
     * 可以使用thenRunAsync(Runnable action,Executor executor)来指定设置的回调事件使用自定义线程池线程来执行，
     * 也就是oneFuture 对应的任务与在其上设置的回调执行将不会在同一个线程中执行
     * @throws Exception
     */
    public static void thenRun()throws Exception{

        //创建异步任务，并返回oneFuture
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(
                new Supplier<String>(){

                    @Override
                    public String get() {

                        //休眠2s,模拟任务计算
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //返回计算结果
                        return "oneFuture";
                    }
                });


        //在oneFuture 上施加事件，当oneFuture 计算完成后回调该事件，并返回新twoFuture
        CompletableFuture twoFuture = oneFuture.thenRun(
                new Runnable(){

                    @Override
                    public void run() {

                        //休眠2s,模拟任务计算
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName());

                        System.out.println("------after oneFuture over doSomething-----");
                    }
                });

        //同步等待twoFuture 对应的任务完成，返回结果固定为null
        System.out.println(twoFuture.get());


    }


    /**
     * 基于thenAccept实现异步任务A，执行完毕后，激活异步任务B执行，
     * 需要注意的是，这种方式激活的异步任务B是可以拿到任务A的执行结果的
     *
     * 在默认情况下，oneFuture 对应的异步任务和在oneFuture 上添加的回调事件都是使用ForkJoinPool.commonPool()中的同一个线程来执行的
     * 可以使用thenAcceptAsync(Consumer<? superT> action,Executor executor)来指定设置的回调事件使用自定义线程池线程来执行，
     * 也就是onefuture 对应的任务与在其上设置的回调执行将不会在同一个线程中执行
     *
     * @throws Exception
     */
    public static void thenAccept()throws Exception{

        //创建异步任务是，并返回future
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(
                new Supplier<String>(){

                    @Override
                    public String get() {

                        //休眠2s，模拟任务计算
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e){
                         e.printStackTrace();
                        }
                        return "oneFutureResult";
                    }
                });

        //在oneFuture 上施加事件，当oneFuture 计算完成后回调该事件，并返回新future
        CompletableFuture twoFuture = oneFuture.thenAcceptAsync(
                new Consumer<String>(){
                    @Override
                    public void accept(String s) {

                        //对oneFuture 返回的记过进行加工
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        System.out.println("-----after oneFuture over doSomething-------" + s);
                    }
                },
                POOL_EXECUTOR);

        System.out.println(twoFuture.get());

    }

    /**
     * 基于thenApply实现异步任务A，执行完毕后，激活异步任务B执行。
     * 需要注意的是，这种方式激活的异步任务B是可以拿到任务A的执行结果的，
     * 并且可以获取到异步任务B的执行结果。
     *
     * 默认情况下oneFuture 对应的异步任务和oneFuture 上添加的回调事件都是使用ForkJoinPool.commonPool()中的同一个线程来执行的，
     * 可以使用thenApplyAsync(Function<? super T,? extends U> fn,Executor executor)来指定设置的回调事件使用自定义线程池线程来执行
     * 也就是oneFuture 对应的任务与在其上设置的回调执行将不会在同一个线程中执行
     *
     * @throws Exception
     */
    public static void thenApply()throws Exception{

        //创建异步任务，并返回future
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(
                new Supplier<String>(){

                    @Override
                    public String get() {

                        try{
                            Thread.sleep(2000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        //返回计算结果
                        return "oneFutureResult";
                    }
                });
        //在oneFuture 上施加事件，当oneFuture 计算完成后回调该事件，并返回twoFuture
        CompletableFuture<String> twoFuture = oneFuture.thenApply(
                new Function<String, String>() {
                    //在oneFuture 返回的记过基础上进行计算，这里s 为oneFuture 返回的oneFutureResult
                    @Override
                    public String apply(String s) {

                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        return "加工后的结果 ： " + s + " sssss";
                    }
                }
        );

        System.out.println(twoFuture.get());
    }


    /**
     * 基于whenComplete设置回调函数，当异步任务执行完毕后进行回调，不会阻塞调用线程：
     * @throws Exception
     */
    public static void whenComplete()throws Exception{

        //创建一个CompletableFuture 对象
        CompletableFuture<String> future = CompletableFuture.supplyAsync(
                new Supplier<String>(){

                    @Override
                    public String get() {

                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        return "futureResult";
                    }
                });

        //添加回调函数
        future.whenComplete(new BiConsumer<String, Throwable>(){
            @Override
            public void accept(String s, Throwable throwable) {

                //如果没有异常，打印异步任务结果
                if (null == throwable){
                    System.out.println(s);
                }else {
                    System.out.println(throwable.getLocalizedMessage());
                }
            }
        });

        /**
         * 挂起当前线程，等待异步任务执行完毕
         * 这里挂起main 函数所在线程，是因为具体执行异步任务的是ForkJoin的commonPool线程池，其中线程都是Deamon线程
         * 所以，当唯一的用户线程main 线程推出后整个JVM 进程就退出了，会导致异步任务得不到执行
         */
        Thread.currentThread().join();

    }

    /*
    如上所述，当我们使用CompletableFuture实现异步编程时，大多数时候是不需要显式创建线程池，并投递任务到线程池内的。我们只需要简单地调用CompletableFuture的runAsync或者supplyAsync等方法把异步任务作为参数即可，其内部会使用ForkJoinPool线程池来进行异步执行的支持，这大大简化了我们异步编程的负担，实现了声明式编程（告诉程序我要执行异步任务，但是具体怎么实现我不需要管），当然如果你想使用自己的线程池来执行任务，也是可以非常方便地进行设置的。
     */









    public static void main(String[] args)throws Exception{
        whenComplete();
    }
}
