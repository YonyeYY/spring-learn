package org.airyny.spring.learn.mybatis.pub.server;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/9 18:01
 * @Version:1.0
 * @deseription:
 **/
public class MessageCustomer implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("监听的消息："+message.toString());
    }
}
