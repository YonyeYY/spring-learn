package web.app.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RabbitConsmer {

    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "10.73.156.189";
    private static final int PORT = 5672;

    public static void main(String[] args)throws Exception{
        Address[] addresses = new Address[]{
                new Address(IP_ADDRESS,PORT)
        };

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");

        //这里德连接方式与生产者的 demo略有不同，注意辨别区别
        Connection connection = factory.newConnection(addresses);//创建连接
        final Channel channel = connection.createChannel();//创建信道
        channel.basicQos(64);//设置客户端最多接收未被ack 的消息的个数
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,AMQP.BasicProperties properties,
                                       byte[] body) {
                System.out.println("recv message: " + new String(body));
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                try {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        channel.basicConsume(QUEUE_NAME,consumer);
        //等待回调函数执行完毕之后，关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();

    }
}
