package com.practice.JavaIO.JavaBIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 早期的JavaAPI只支持由本地系统套接字库提供的阻塞函数
 * 这是一个使用这些函数调用的服务器代码的例子
 * @author zhaoxu
 * @className IOServer
 * @projectName JavaConcentration

 * @date 2/27/2020 4:26 PM
 */
public class IOServer {

    public static void main(String[] args) throws IOException {

        //端口号
        int serverPortNum = 8800;
        //create serverSocket
        //listen to 8000
        //创建一个新的 ServerSocket，用以监听指定端口上的连接请求
        ServerSocket serverSocket = new ServerSocket(serverPortNum);
        new Thread(()->{
           //endless call
            while (true){
                try {
                    // (1) 阻塞方法获取新的连接
                    //The method blocks until a connection is made.
                    //随后返回一个新的socket链接,用于客户端和服务器之间的通信
                    //该ServerSocket对象将继续监听传入的连接
                    //对accept()方法的调用将被阻塞，直到一个连接建立
                    Socket socket = serverSocket.accept();
                    // (2) 每一个新的连接都创建一个线程，负责读取数据,
                    //此时会有大量的线程处于休眠状态,只是等待输入或者输出数据就绪
                    //这种一个线程处理一个连接的方案,只是中小数量的客户端可以接受
                    //一旦业务量达到十万级别(刚测试本地环境最多线程数11w),就完全无法使用了
                    //这时就要用到NIO
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            //Returns an input stream for this socket.
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
