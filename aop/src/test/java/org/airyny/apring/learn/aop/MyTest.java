package org.airyny.apring.learn.aop;

import java.math.BigDecimal;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 9:39
 * @Version:1.0
 * @deseription:
 **/
public class MyTest {

    public static void main(String[] args){
        BigDecimal result = BigDecimal.ONE;
        System.out.println(result);
        result = result.multiply(new BigDecimal("-123"));
        System.out.println(result);
    }
}
