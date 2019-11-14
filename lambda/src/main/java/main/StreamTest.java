package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/14 21:08
 * @Version:1.0
 * @deseription:
 **/
public class StreamTest {

    public static void main(String[] args){

            List<String> players =new ArrayList();
            players.add("zhansgan");
            players.add("lisi");
            players.add("wangwu");
            players.add("zhaoliu");
            players.add("wangmazi");

            List<String> list = players.stream()
                    .filter(arReceiptsAllVo -> "lisi".equals(arReceiptsAllVo)).collect(Collectors.toList());
            for (String item:list){
                System.out.println(item);
            }

    }
}
