package org.airyny.spring.learn.mybatis.pub.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/24 21:03
 * @Version:1.0
 * @deseription:
 **/
@Service
public class KafkaSendMessageServiceImpl implements MessageListener<String,String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        //根据不同主题，消费
        System.out.println("========");
        if("topic1".equals(data.topic())){
            //逻辑1
            System.out.println(data.value()+"被消费");
        }else if("topic2".equals(data.topic())){
            //逻辑2
            System.out.println(data.value()+"主题2 被消费");
        }
    }
}
