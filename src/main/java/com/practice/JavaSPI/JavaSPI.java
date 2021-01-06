package com.practice.JavaSPI;

import java.util.ServiceLoader;

/**
 * JavaSPI全程是Service Provider Interface
 * 测试类
 * @author zhaoxu
 * @className JavaSPI
 * @projectName JavaConcentration
 * @date 2020/6/20 12:47
 */
public class JavaSPI {
    public static void main(String[] args) {
        ServiceLoader<PrintService> serviceServiceLoader = ServiceLoader.load(PrintService.class);
        for (PrintService printService:serviceServiceLoader) {
            printService.print();
        }
    }
}
