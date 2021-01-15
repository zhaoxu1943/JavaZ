package com.concentration.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author zhaoxu
 * @className ZKafkaConsumerUtil
 * @projectName JavaConcentration
 * @date 2021/1/15 8:45
 */
public class ZKafkaConsumerUtil {
    /**
     * broker列表
     * @author zhaoxu
     */
    public static final String brokerList = "localhost:9092";
    /**
     * 河南资产topic
     * @author zhaoxu
     */
    public static final String topic = "test_topic";
    public static final String groupId = "group.demo";

    public static void main(String[] args) {
        //属性集
        Properties properties = new Properties();
        properties.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", brokerList);
        //设置消费组的名称，具体的释义可以参见第3章
        properties.put("group.id", groupId);
        //创建一个消费者客户端实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        //订阅主题
        consumer.subscribe(Collections.singletonList(topic));
        //循环消费消息
        while (true) {
            ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }
    }
}

