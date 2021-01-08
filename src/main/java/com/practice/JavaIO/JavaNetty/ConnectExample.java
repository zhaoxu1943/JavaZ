package com.practice.JavaIO.JavaNetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * 异步的建立连接 回调实战
 * @author zhaoxu
 * @className ConnectExample
 * @projectName JavaConcentration
 * @date 2021/1/8 8:35
 */
public class ConnectExample {
    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();

    /**
     * 代码清单 1-3 异步地建立连接
     *
     * 代码清单 1-4 回调实战
     * */
    public static void connect() {
        Channel channel = CHANNEL_FROM_SOMEWHERE; //reference form somewhere
        // Does not block
        //异步地连接到远程节点
        ChannelFuture future = channel.connect(
                new InetSocketAddress("127.0.0.1", 8000));
        //注册一个 ChannelFutureListener，以便在操作完成时获得通知
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                //检查操作的状态
                if (future.isSuccess()) {
                    //如果操作是成功的，则创建一个 ByteBuf 以持有数据
                    ByteBuf buffer = Unpooled.copiedBuffer(
                            "Hello", Charset.defaultCharset());
                    //将数据异步地发送到远程节点。返回一个 ChannelFuture
                    ChannelFuture wf = future.channel()
                            .writeAndFlush(buffer);
                    // ...
                } else {
                    //如果发生错误，则访问描述原因的 Throwable
                    Throwable cause = future.cause();
                    cause.printStackTrace();
                }
            }
        });
    }
}