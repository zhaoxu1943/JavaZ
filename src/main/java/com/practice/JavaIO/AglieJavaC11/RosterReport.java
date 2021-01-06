package com.practice.JavaIO.AglieJavaC11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author zhaoxu
 * @className RosterReport
 * @projectName JavaConcentration
 * @date 2020/7/7 15:07
 */
public class RosterReport {

    private String message;

    public RosterReport(String message) {
        this.message = message;
    }

    public String getReport() {
        return "report message: "+message;
    }

    /**
     * 写入StringWriter()
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public void writeReport(Writer writer) throws IOException {
        writer.write("report message: "+message);
    }

    /**
     * BufferedWriter(new FileWriter(fileName)))包装,写入文件
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public void writeReport(String fileName) throws IOException {
        //Java 7 的编译器和运行环境支持新的 try-with-resources 语句，
        // 称为 ARM 块(Automatic Resource Management) ，自动资源管理。
        //新的语句支持包括流以及任何可关闭的资源，一般我们会编写finally来释放资源：
        //数据流会在 try 执行完毕后自动被关闭，前提是，这些可关闭的资源必须实现 java.lang.AutoCloseable 接口。
        try (Writer bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            writeReport(bufferedWriter);
        }
        //try结束流自动关闭
    }


}
