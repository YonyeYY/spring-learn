package org.airyny.spring.learn.mybatis.pub.dao.pub;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/10 9:37
 * @Version:1.0
 * @deseription:
 **/
public class HelloImpl implements IHelloService {
    @Override
    public void say() {
        System.out.println("Hello!!!");
    }
}
