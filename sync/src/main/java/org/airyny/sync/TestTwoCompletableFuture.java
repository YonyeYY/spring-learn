package org.airyny.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class TestTwoCompletableFuture {


    //开启异步任务，返回future
    public static CompletableFuture<String> doSomethingOne(String encodedCompanyId){

        //创建异步任务
        return CompletableFuture.supplyAsync(new Supplier<String>(){

            @Override
            public String get() {

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                String id = encodedCompanyId;
                System.out.println("id: "+id);
                return id;
            }
        });
    }


    //开启异步任务，返回future
    public static CompletableFuture<String> doSomethingTwo(String id){

        //创建异步任务
        return CompletableFuture.supplyAsync(new Supplier<String>(){

            @Override
            public String get() {

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //查询公司信息，转换为str，并返回
                String str = id + ":alibaba";
                return str;
            }
        });
    }

    /**
     * 基于thenCompose实现当一个CompletableFuture执行完毕后，执行另外一个CompletableFuture：
     * @throws Exception
     */
    public static void thenCompose()throws Exception{

        //等doSomethingOne 执行完毕后，接着执行doSomethingTwo
        CompletableFuture result = doSomethingOne("123").thenCompose(
                id->doSomethingTwo(id));

        System.out.println(result.get());
    }


    /**
     * 基于thenCombine实现当两个并发运行的CompletableFuture任务都完成后，使用两者的结果作为参数再执行一个异步任务，这里只需要把上面例子中的：
     * @throws Exception
     */
    public static void thenCombine()throws Exception{
        //等doSomethingOne、doSomethingTwo 并发执行
        CompletableFuture result = doSomethingOne("123").thenCombine(
                doSomethingTwo("222"),(one, two)->{return one + " " + two;});

        System.out.println(result.get());
    }


    /**
     * 基于allOf等待多个并发运行的CompletableFuture任务执行完毕：
     * @throws Exception
     */
    public static void allOf()throws Exception{

        //创建future 列表
        List<CompletableFuture<String>> futureList = new ArrayList<>();

        futureList.add(doSomethingOne("1"));
        futureList.add(doSomethingOne("2"));
        futureList.add(doSomethingOne("3"));
        futureList.add(doSomethingOne("4"));
        futureList.add(doSomethingOne("5"));


        //转换多个future 为一个
        CompletableFuture<Void> result = CompletableFuture
                .allOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        //等待所有future 都完成
        System.out.println(result.get());

    }


    /**
     * 基于anyOf等多个并发运行的CompletableFuture任务中有一个执行完毕就返回：
     * @throws Exception
     */
    public static void anyOf()throws Exception{

        //创建future 列表
        List<CompletableFuture<String>> futureList = new ArrayList<>();

        futureList.add(doSomethingOne("1"));
        futureList.add(doSomethingOne("2"));
        futureList.add(doSomethingOne("3"));
        futureList.add(doSomethingOne("4"));
        futureList.add(doSomethingOne("5"));


        //转换多个future 为一个
        CompletableFuture<Object> result = CompletableFuture
                .anyOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        //等待所有future 都完成
        System.out.println(result.get());

    }

    /**
     * 异常处理
     * 我们不仅需要考虑正常设置结果的情况，还需要考虑异常的情况，
     * 其实CompletableFuture提供了completeExceptionally方法来处理异常情况
     */
    public static void exceptionDeal()throws Exception{
        //创建一个CompletableFuture 对象
        CompletableFuture<String> future = new CompletableFuture<String>();

        //开启线程计算任务结果，并设置
        new Thread(()->{

            try{
                //抛出异常
                if (true){
                    throw new RuntimeException("excetion test");
                }

                //设置正常结果
                future.complete("ok");
            }catch (Exception e){

                //设置异常结果
                future.completeExceptionally(e);
            }
            System.out.println("---" + Thread.currentThread().getName() + "set future result-----");

        },"thread---1").start();

       // System.out.println(future.get());

        //当出现异常时返回默认值
        System.out.println(future.exceptionally(t -> "default").get());

    }

    public static void main(String[] args)throws Exception{
        exceptionDeal();
    }


}
