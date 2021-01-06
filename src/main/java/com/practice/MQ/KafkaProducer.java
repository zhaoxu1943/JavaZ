package com.practice.MQ;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;

/**
 * @author zhaoxu
 * @version 1.0
 * @className KafkaProducerAndConsumer

 * @date 2020/1/7 20:08
 **/
public class KafkaProducer {

    //代码清单2-1 生产者客户端示例代码

    public static final String brokerList = "kafka1:9092";
    public static final String topic = "topic001";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);


        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer =
                new org.apache.kafka.clients.producer.KafkaProducer<>(properties);
        ProducerRecord<String, String> record =
                new ProducerRecord<>(topic, "hello, Kafka!我成功了!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
