package com.practice.JavaIO.AglieJavaC11;

import com.concentration.entity.UserInfo;
import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;

/**
 * 高级流
 * 管道(piped)流
 * @author zhaoxu
 * @className JavaStream
 * @projectName JavaConcentration
 * @date 2020/7/9 11:22
 */
public class JavaStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //管道流,可以使用管道流在不同线程间进行安全的基于IO的数据通讯,管道流以成对的方式工作
        //被写入的,输出管道流数据,会被与之相连的输入管道流读取
        InputStream inputStreamPiped = new PipedInputStream();
        OutputStream outputStreamPiped = new PipedOutputStream();
        Reader readerPiped = new PipedReader();
        Writer writerPiped = new PipedWriter();

        //PushBack流,用于词法分析程序,如编译器的分词程序,他们可以将程序放回流中,就如它没有被读取一样
        InputStream inputStreamPushBack = new PushbackInputStream(inputStreamPiped);
        Reader readerPushBack = new PushbackReader(readerPiped);


        //序列流,使一组输入流的行为如同一个单独的输入流一样,资源的集合是有序的,当一个资源被完整的读取后,
        //它就会被关闭,然后集合中的下一个流开始打开-读取-关闭
        InputStream inputStreamSeq = new SequenceInputStream(inputStreamPiped,inputStreamPushBack);


        //对象流,Java提供了直接从/向流中读写对象的能力,Java可以借由对象的序列化(serialization),将对象写到对象的输出流中
        //Java通过将对象转换为一个字节的序列,将之序列化
        //将对象序列化的能力,是Java RMI的基础,RMI(Remote Method Invocation)能让对象在同远程系统中的对象交互时,就像访问
        //本地对象一样,RMI进而是java EJB的基础
        final String fileName = "wdnmd.txt";
        store(fileName);
        load(fileName);
    }





    /**
     * 存储序列化对象流
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void store(String fileName) throws IOException {
        //对象输出流
        UserInfo userZ =  new UserInfo();
        userZ.setUserName("nihao");
        userZ.setUserId("W0001");
        //向输出对象流中,写对象
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(userZ);
        }
    }


    /**
     * 存储序列化对象流
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void storeNoResource(String fileName) throws IOException {
        //对象输出流
        UserInfo userZ =  new UserInfo();
        userZ.setUserName("nihao");
        userZ.setUserId("W0001");
        ObjectOutputStream objectOutputStream = null;
        //向输出对象流中,写对象
        try  {
            objectOutputStream= new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(userZ);
        }finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
        }
    }



    /**
     * 加载序列化对象流
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
           UserInfo userInfo = (UserInfo) inputStream.readObject();
            System.out.println(userInfo.getUserName());
        }
    }
}
