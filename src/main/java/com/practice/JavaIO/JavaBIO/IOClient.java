package com.practice.JavaIO.JavaBIO;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author zhaoxu
 * @className IOClient
 * @projectName JavaConcentration

 * @date 2/27/2020 4:29 PM
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            //create socket
            try {
                Socket socket = new Socket("127.0.0.1", 8800);
                //endless
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + "hello world!").getBytes());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
