package org.airyny.spring.learn.mybatis.pub.dao.pub;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/10 9:38
 * @Version:1.0
 * @deseription:
 **/
public class HelloWord extends HelloImpl implements IHelloService{
    @Override
    public void say() {
        System.out.println("balbalbal");
    }
}
