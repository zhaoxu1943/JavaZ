package com.concentration.util;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author zhaoxu
 * @className ZKafkaProducerUtil
 * @projectName JavaConcentration
 * @date 2021/1/15 8:45
 */
public class ZKafkaProducerUtil {
    /**
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static final String brokerList = "localhost:9092";
    /**
     * 河南移动topic
     * @author zhaoxu
     */
    public static final String topic = "test_topic";

    /**
     * 静态方法初始化kafka producer属性
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static Properties initConfig(){
        Properties props = new Properties();
        //必选属性一
        //bootstrap.servers
        //该参数用来指定生产者客户端连接 Kafka 集群所需的 broker 地址清单，具体的内容格式为 host1:port1,host2:port2
        //可以设置一个或多个地址，中间以逗号隔开，此参数的默认值为""
        //注意这里并非需要所有的 broker 地址，因为生产者会从给定的 broker 里查找到其他 broker 的信息。
        // 不过建议至少要设置两个以上的 broker 地址信息，当其中任意一个宕机时，生产者仍然可以连接到 Kafka 集群上。
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        //发往 broker 之前需要将消息中对应的 key 和 value 做相应的序列化操作来转换成字节数组
        //key.serializer 和 value.serializer 这两个参数分别用来指定 key 和 value 序列化操作的序列化器，
        // 这两个参数无默认值。注意这里必须填写序列化器的全限定名
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        //client.id，这个参数用来设定 KafkaProducer 对应的客户端id，默认值为""
        //如果客户端不设置，则 KafkaProducer 会自动生成一个非空字符串，内容形式如"producer-1"、"producer-2"，即字符串"producer-"与数字的拼接。
        //超时次数,如果重试了10次之后还没有恢复，那么仍会抛出异常
        props.put(ProducerConfig.RETRIES_CONFIG, 10);
        //多个消息同时被发送 ,批次大小 ,以内存数计算,减少网络开销
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,10000);
        return props;
    }


    public static void main(String[] args) {
        //属性集
        Properties props = initConfig();
        // Kafka生产者客户端实例
        //是线程安全的，可以在多个线程中共享单个 KafkaProducer 实例，
        // 也可以将 KafkaProducer 实例进行池化来供其他线程调用。
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        //至此kafka producer创建完成


        //构建消息的 ProducerRecord 对象,不是单纯意义上的消息,它包含了多个属性
        //需要发送的消息只是其中的一个value属性
        //针对不同的消息，需要构建不同的 ProducerRecord 对象，在实际应用中创建 ProducerRecord 对象是一个非常频繁的动作。
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "msg","hello, wdnmd!");
        try {
            //创建生产者实例和构建消息之后，就可以开始发送消息了。
            // 发送消息主要有三种模式：发后即忘（fire-and-forget）、同步（sync）及异步（async）。
            //1.发后即忘,它只管往 Kafka 中发送消息而并不关心消息是否正确到达
            //这种发送方式的性能最高，可靠性也最差。
            // producer.send(record);
            //2.同步
            ZKafkaProducerUtil kafkaProducerUtil = new ZKafkaProducerUtil();
            kafkaProducerUtil.sendSync(producer,record);
            //3.异步,使用匿名内部类
            producer.send(record, new Callback() {
                /**
                 * 完成时的回调方法
                 * onCompletion() 方法的两个参数是互斥的，
                 * 消息发送成功时，metadata 不为 null 而 exception 为 null；
                 * 消息发送异常时，metadata 为 null 而 exception 不为 null。
                 * @author zhaoxu
                 * @param metadata 发送的记录的元数据（即分区和偏移量）。如果发生错误*，则为Null。
                 * @param exception 处理此记录期间引发的异常。如果没有发生错误，则为Null。
                 */
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception != null) {
                        exception.printStackTrace();
                    } else {
                        System.out.println(metadata.topic() + "-" +
                                metadata.partition() + ":" + metadata.offset());
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        //close() 方法会阻塞等待之前所有的发送请求完成后再关闭 KafkaProducer
        producer.close();
    }

    /**
     * 同步发送
     * 同步发送的方式可靠性高，要么消息被发送成功，
     * 要么发生异常。如果发生异常，则可以捕获并进行相应的处理，
     * 而不会像“发后即忘”的方式直接造成消息的丢失。
     * 不过同步发送的方式的性能会差很多，需要阻塞等待一条消息发送完之后才能发送下一条。
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private void sendSync(KafkaProducer<String, String> producer,ProducerRecord<String, String> record) {
        try {
            //send() 方法本身就是异步的，send() 方法返回的 Future 对象可以使调用方稍后获得发送的结果。
            // 示例中在执行 send() 方法之后直接链式调用了 get() 方法来阻塞等待 Kafka 的响应，直到消息发送成功，或者发生异常。如果发生异常，那么就需要捕获异常并交由外层逻辑处理。
            producer.send(record).get();

            //way2:得到主题,分区号,偏移量,时间戳等信息
//            Future<RecordMetadata> future = producer.send(record);
//            RecordMetadata metadata = future.get();
//            System.out.println(metadata.topic() + "-" +
//                    metadata.partition() + ":" + metadata.offset());
        } catch (ExecutionException | InterruptedException e) {
            throw new IllegalArgumentException("Kafka同步发送消息失败,消息内容为:"+record.value());
        }
    }





}