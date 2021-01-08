package com.practice.JavaIO.JavaNetty;

import io.netty.bootstrap.*;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @author zhaoxu
 * @className NettyClient
 * @projectName JavaConcentration

 * @date 2/28/2020 10:57 AM
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {

        //客户端引导
        Bootstrap bootstrap = new Bootstrap();
        //客户端Bootstrap 可用于连接远端服务器，只绑定一个 EventLoopGroup
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //至此引导声明完毕
        //有了 Bootstrap 组件，我们可以更加方便地配置和启动 Netty 应用程序，
        // 它是整个 Netty 的入口，串接了 Netty 所有核心组件的初始化工作。





                // 1.指定线程模型
        bootstrap
                .group(workerGroup)
                // 2.指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
            // 3.IO 处理逻辑
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();

        while (true) {
            channel.writeAndFlush(new Date() + ": hello world!");
            Thread.sleep(2000);
        }
    }
}
