package com.practice.JavaSPI;

/**
 * @author zhaoxu
 * @className PrintServiceImpl
 * @projectName JavaConcentration
 * @date 2020/6/20 13:17
 */
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        System.out.println("hello java spi!");
    }
}
