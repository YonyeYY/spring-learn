package org.airyny.spring.learn.mybatis.pub.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/22 17:59
 * @Version:1.0
 * @deseription:
 **/
@Service("sendMessage")
public class SendMessage {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public synchronized void sendMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }

}
