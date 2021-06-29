package org.airyny.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class StreamTestFuture {


    public static String rpcCall(String ip, String param){

        System.out.println(ip + " rpcCall:" + param);

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        return param;
    }

    public static void streamMain(String[] args){

        //生成ip 列表
        List<String> ipList = new ArrayList<String>();
        for(int i=1; i<=10; ++i){
            ipList.add("192.168.0."+i);
        }

        int i =1;
        System.out.println(i++);

        System.out.println(++i);

        //发起广播调用
        long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();

        for(String ip: ipList){
            result.add(rpcCall(ip, ip));
        }

        //输出
        result.stream().forEach(r-> System.out.println(r));

        System.out.println("cost:" + (System.currentTimeMillis()-start));

    }

    public static void completableMain() {

        //生成ip 列表
        List<String> ipList = new ArrayList<String>();
        for (int i = 1; i <= 10; ++i) {
            ipList.add("192.168.0." + i);
        }

        //发起广播调用
        long start = System.currentTimeMillis();


        //completableFuture 与JDK Stream结合
        List<CompletableFuture<String>> futureList = ipList.stream()
                .map(ip->CompletableFuture.supplyAsync(()->rpcCall(ip, ip)))
                .collect(Collectors.toList());

        List<String> resultList = futureList.stream()
                .map(future->future.join())
                .collect(Collectors.toList());

        resultList.stream().forEach(r-> System.out.println(r));

        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }


    public static void main(String[] args){
        completableMain();
    }
}
