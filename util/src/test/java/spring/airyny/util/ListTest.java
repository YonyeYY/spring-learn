package spring.airyny.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/12/24 14:21
 * @Version:1.0
 * @deseription:
 **/
public class ListTest {

    @Test
    public void listTest(){
        List list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        System.out.println("迭代器");
        Iterator it = list.iterator();
        while(it.hasNext()){
            Object item = it.next();
            String s = (String)item;
            System.out.println("读取集合元素："+s);
        }

    }
}
