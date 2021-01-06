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

        //start server
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //bossGroup used like "Socket socket = serverSocket.accept();" (The method blocks until a connection is made.)
        //bossGroup accept new connect,but not blocked
        //accept
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        //workergroup reading the data
        //handle
        NioEventLoopGroup workergroup = new NioEventLoopGroup();


        serverBootstrap
                //open Nagle
                .childOption(ChannelOption.TCP_NODELAY,true)
                .group(bossGroup,workergroup)
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
