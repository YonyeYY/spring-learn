package org.airyny.spring.learn.mybatis.pub.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/23 14:56
 * @Version:1.0
 * @deseription:
 **/
@Service
public class SendRedis {
    @Autowired
    SendMessage sendMessage;

    public void outPut(){
        for (int i = 0; i < 10; i++) {
            sendMessage.sendMessage("channel1.0", "第" + i + "次发送信息");
        }
    }
}
