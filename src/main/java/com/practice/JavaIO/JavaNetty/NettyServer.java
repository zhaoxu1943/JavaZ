package com.practice.JavaIO.JavaNetty;

import io.netty.bootstrap.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;


/**
 * @author zhaoxu
 * @className NettyServer
 * @projectName JavaConcentration

 * @date 2/28/2020 9:52 AM
 */
public class NettyServer {
    public static void main(String[] args) {

        //服务端引导
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //ServerBootstrap
        //绑定两个 EventLoopGroup，这两个 EventLoopGroup 通常称为 Boss 和 Worker。

        //这里的 Boss 和 Worker 可以理解为“老板”和“员工”的关系。每个服务器中都会有一个 Boss，
        // 也会有一群做事情的 Worker。
        // Boss 会不停地接收新的连接，然后将连接分配给一个个 Worker 处理连接。

        //bossGroup used like "Socket socket = serverSocket.accept();" (The method blocks until a connection is made.)
        //bossGroup accept new connect,but not blocked
        //accept
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();



        //workerGroup reading the data
        //handle
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        //至此引导声明完毕
        //有了 Bootstrap 组件，我们可以更加方便地配置和启动 Netty 应用程序，
        // 它是整个 Netty 的入口，串接了 Netty 所有核心组件的初始化工作。


        serverBootstrap
                //open Nagle
                .childOption(ChannelOption.TCP_NODELAY,true)
                .group(bossGroup,workerGroup)
                //IO model
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                .bind(8000);
    }
}
