package org.airyny.spring.learn.mybatis.pub.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/24 10:29
 * @Version:1.0
 * @deseription:
 **/
@Service
public class KafkaConsumerServer implements MessageListener<String, Object> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerServer.class);

    /**
     * 监听器自动执行该方法->消费消息->自动提交offset->执行业务代码.
     * （high level api 不提供offset管理，不能指定offset进行消费）.
     *
     * @param record 接收到的消息对象
     */
    @Override
    public void onMessage(ConsumerRecord<String, Object> record) {
        logger.info("=============kafkaConsumer start consumption=============");
        logger.info("=============topic:[{}],key:[{}],value:[{}],offset:[{}],partition:[{}]=============",
                record.topic(), record.key(), record.value(), record.offset(), record.partition());
        // 处理接收消息
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            System.out.println(record.topic()+record.value());
        }
        logger.info("=============kafkaConsumer end of consumption=============");
    }

}
