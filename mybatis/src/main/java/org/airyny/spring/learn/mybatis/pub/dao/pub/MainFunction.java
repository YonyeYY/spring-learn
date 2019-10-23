package org.airyny.spring.learn.mybatis.pub.dao.pub;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/10 9:40
 * @Version:1.0
 * @deseription:
 **/
public class MainFunction {

    public static void main(String[] args){
        IHelloService service = new HelloWord();
        service.say();
        Map<String,String> map = new HashMap<>();
        map.put("key","jun");
        map.put("key2","Tom");
        System.out.println(map.get("key"));
        System.out.println(map.entrySet());
        System.out.println(map);
        map.put("key","jun2");
        System.out.println(map.get("key"));
        System.out.println(map.entrySet());
        System.out.println(map);

    }
}
