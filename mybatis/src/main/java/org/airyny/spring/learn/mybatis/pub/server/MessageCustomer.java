package org.airyny.spring.learn.mybatis.pub.server;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/9 18:01
 * @Version:1.0
 * @deseription:
 **/
public class MessageCustomer implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        try {
            System.out.println("监听的消息："+ new String(message.getChannel(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
