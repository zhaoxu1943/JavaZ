package com.practice.JavaIO.AglieJavaC11;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author zhaoxu
 * @className RosterReportTest
 * @projectName JavaConcentration
 * @date 2020/7/7 15:20
 */
public class RosterReportTest {

    @Test
    public void getReport()  {
        RosterReport rosterReport = new RosterReport("wdnmd");
        String infoProcess = rosterReport.getReport();
        Assert.assertEquals("不一致!","report message: wdnmd",infoProcess);
    }

    @Test
    public void writeReport() throws IOException {
        Writer writer = new StringWriter();
        new RosterReport("wdnmd").writeReport(writer);
        String writeStr = writer.toString();
        Assert.assertEquals("不一致!","report message: wdnmd",writeStr);
    }


    @Test
    public void writeFileReport() throws IOException {
        final String fileName = "wdnmd.txt";
        new RosterReport("wdnmd").writeReport(fileName);

        StringBuffer buffer = new StringBuffer();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while((line=reader.readLine())!=null)
        buffer.append(line);
        reader.close();

        Assert.assertEquals("不一致!","report message: wdnmd",buffer.toString());
    }

    @Test
    public void filedReport()  throws IOException,InterruptedException {
        final String fileName = "wdnmd.txt";
        try{
            checkFileExistsAndDelete(fileName);
            new RosterReport("wdnmd").writeReport(fileName);

            StringBuffer buffer = new StringBuffer();
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while((line=reader.readLine())!=null)
                buffer.append(line);
            reader.close();

            Assert.assertEquals("不一致!","report message: wdnmd",buffer.toString());
            Thread.sleep(5000);



        }finally {
            checkFileExistsAndDelete(fileName);
        }

    }






    private void checkFileExistsAndDelete(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            Assert.assertTrue("不能删除"+fileName,file.delete());
        }
    }


}