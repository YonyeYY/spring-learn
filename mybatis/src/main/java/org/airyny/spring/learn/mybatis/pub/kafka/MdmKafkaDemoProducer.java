package org.airyny.spring.learn.mybatis.pub.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * MDM主数据接口，定义生产者类.
 *
 * @author houmin(min.hou@hand-china.com)
 * @date 2018-12-01 10:56
 */
public class MdmKafkaDemoProducer {

    private static KafkaProducer<String, String> producer;
    private final static String TOPIC = "demo";

    public MdmKafkaDemoProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        /*设置大于0的值将使客户端重新发送任何数据，一旦这些数据发送失败。
        注意，这些重试与客户端接收到发送错误时的重试没有什么不同。
        允许重试将潜在的改变数据的顺序，如果这两个消息记录都是发送到同一个partition，则第一个消息失败第二个发送成功，
        则第二条消息会比第一条消息出现要早。*/
        props.put("retries", 0);
        props.put("batch.size", 16384);
        /*这项设置设定了批量处理的更高的延迟边界：
        一旦我们获得某个partition的batch.size，他将会立即发送而不顾这项设置，
        然而如果我们获得消息字节数比这项设置要小的多，我们需要“linger”特定的时间以获取更多的消息。*/
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 设置分区类,根据key进行数据分区
        producer = new KafkaProducer<String, String>(props);
    }

    public void produce() {
        String data = "{\n" +
                "\t\"datetime\": \"2018-12-07 15:23:34\",\n" +
                "\t\"type\": \"MD0011001\",\n" +
                "\t\"version\": 1.0,\n" +
                "\t\"messageId\": \"606c3b90-f78f-11e8-8b50-d145f8de19ab\",\n" +
                "\t\"mdmProjectHead\": {\n" +
                "\t\t\"id\": \"606c3b90-f78f-11e8-8b50-d145f8de19ab\",\n" +
                "\t\t\"landName\": \"测试面积分发1\",\n" +
                "\t\t\"isMergeReportIpo\": 1,\n" +
                "\t\t\"code\": \"P0075\",\n" +
                "\t\t\"infraredRequirement\": \"aaaaaaaaaaaaaa\",\n" +
                "\t\t\"latitude\": 0,\n" +
                "\t\t\"description\": \"描述\",\n" +
                "\t\t\"projectPeriod\": \"d6e82c22a963451fa60c54e8f652f0f7\",\n" +
                "\t\t\"obtainProjectTime\": \"2018-12-03 00:00:00\",\n" +
                "\t\t\"orgCityId\": \"A0000000022\",\n" +
                "\t\t\"cityGeographyName\": \"cityGeographyName\",\n" +
                "\t\t\"businessAttributeCode\": \"P\",\n" +
                "\t\t\"saleName\": \"湖北项目\",\n" +
                "\t\t\"countryCode\": \"CN\",\n" +
                "\t\t\"outsideCode\": \"测试面积分发1\",\n" +
                "\t\t\"responsible\": \"aitao\",\n" +
                "\t\t\"alias\": \"无\",\n" +
                "\t\t\"orgCityName\": \"邯郸公司\",\n" +
                "\t\t\"share\": 0,\n" +
                "\t\t\"approveTime\": \"2019-01-02 10:00:00\",\n" +
                "\t\t\"shareBusiness\": 0,\n" +
                "\t\t\"longitude\": 0,\n" +
                "\t\t\"actualGetTime\": \"2018-12-04 00:00:00\",\n" +
                "\t\t\"orgnazationName\": \"河北区域公司\",\n" +
                "\t\t\"address\": \"雄安新区\",\n" +
                "\t\t\"isMergeReport\": 1,\n" +
                "\t\t\"isResponsibilityMgmt\": 1,\n" +
                "\t\t\"orgnazationId\": \"A2470314399\",\n" +
                "\t\t\"communitySmartPagCode\": \"communitySmartPagCode\",\n" +
                "\t\t\"obtainLandTime\": \"2018-12-05 00:00:00\",\n" +
                "\t\t\"projectState\": \"projectState\",\n" +
                "\t\t\"approveDocNumber\": \"approveDocNumber\",\n" +
                "\t\t\"name\": \"测试面积分发1\",\n" +
                "\t\t\"businessAttributeName\": \"房开业务\",\n" +
                "\t\t\"projectGuidMy\": \"projectGuidMy\",\n" +
                "\t\t\"company\": {\n" +
                "\t\t\t\"companyCode\": \"HBHD_CMP\",\n" +
                "\t\t\t\"country\": \"CHN\",\n" +
                "\t\t\t\"unifiedSocialCreditCode\": \"AAAAAAA\",\n" +
                "\t\t\t\"curreny\": \"CNY\",\n" +
                "\t\t\t\"companyName\": \"河北邯郸公司\",\n" +
                "\t\t\t\"id\": \"HBHD\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        producer.send(new ProducerRecord<String, String>(TOPIC, "1", data));
        System.out.println(data);
        producer.close();
    }

    public static void main(String[] args) {
        new MdmKafkaDemoProducer().produce();
    }


}
