package web.app.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class RabbitMq {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "10.73.156.189";
    private static final int PORT = 5672;


    public static void main(String[] args)throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);

        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);

        //发送一个条持久化得消息：Hello world
        String message = "Hello World5!!!";
        channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());

        //关闭资源
        channel.close();;
        connection.close();

    }
}
