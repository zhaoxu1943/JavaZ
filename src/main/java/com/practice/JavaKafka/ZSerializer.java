package com.practice.JavaKafka;

import com.concentration.entity.UserInfo;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 实现kafka自定义序列化器
 * org.apache.kafka.common.serialization.Serializer
 * 但是比较脆弱
 * 所以还是使用已有的开源序列化和反序列化器
 * 如 avro thrift protobuf
 *
 *
 * @author zhaoxu
 * @className ZSerializer
 * @projectName JavaConcentration
 * @date 2021/1/15 9:37
 */
public  class  ZSerializer implements Serializer<UserInfo> {

    /**
     * Configure this class.
     *
     * @param configs configs in key/value pairs
     * @param isKey   whether is for key or value
     */
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * Convert {@code data} into a byte array.
     *
     * @param topic topic associated with data
     * @param data  typed data
     * @return serialized bytes
     */
    @Override
    public byte[] serialize(String topic, UserInfo data) {
        //创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
        //按一定规则创建自定义的字节数组,使用字节缓冲区进行拼接
        byteBuffer.put(data.getUserName().getBytes(Charset.defaultCharset()));
        byteBuffer.put(data.getSex().getBytes(Charset.defaultCharset()));
        return byteBuffer.array();
    }

    /**
     * Close this serializer.
     * <p>
     * This method must be idempotent as it may be called multiple times.
     */
    @Override
    public void close() {

    }
}
