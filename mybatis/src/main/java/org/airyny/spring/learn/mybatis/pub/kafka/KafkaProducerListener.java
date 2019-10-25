package org.airyny.spring.learn.mybatis.pub.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/24 10:34
 * @Version:1.0
 * @deseription:
 **/
@Service
public class KafkaProducerListener implements ProducerListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerListener.class);

    /**
     * 发送消息成功后调用
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key,
                          Object value, RecordMetadata recordMetadata) {
        logger.info("==========Kafka sending data successfully==========");
        logger.info("----------Topic:" + topic);
        logger.info("----------Partition:" + partition);
        logger.info("----------Key:" + key);
        logger.info("----------Value:" + value);
        logger.info("----------RecordMetadata:" + recordMetadata);
        logger.info("==========Kafka sending data successfully==========");
    }

    /**
     * 发送消息错误后调用
     */
    @Override
    public void onError(String topic, Integer partition, Object key,
                        Object value, Exception exception) {
        logger.info("==========Kafka sending data error==========");
        logger.info("----------Topic:" + topic);
        logger.info("----------Partition:" + partition);
        logger.info("----------Key:" + key);
        logger.info("----------Value:" + value);
        logger.info("----------Exception:" + exception);
        logger.info("==========Kafka sending data error==========");
        exception.printStackTrace();
    }

    /**
     * 方法返回值代表是否启动kafkaProducer监听器
     */
    @Override
    public boolean isInterestedInSuccess() {
        logger.info("///kafkaProducer监听器启动///");
        return true;
    }
}
