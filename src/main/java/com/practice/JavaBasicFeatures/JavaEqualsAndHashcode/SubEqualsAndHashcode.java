package com.practice.JavaBasicFeatures.JavaEqualsAndHashcode;

/**
 * @ClassName SubEqualsAndHashcode

 * @Author zhaoxu
 * @Date 2019/12/3 11:51
 * @Version 1.0
 **/
public class SubEqualsAndHashcode extends EqualsAndHashcode {

    public String size;

    public String computerAge;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getComputerAge() {
        return computerAge;
    }

    public void setComputerAge(String computerAge) {
        this.computerAge = computerAge;
    }

    public SubEqualsAndHashcode() {
    }

    public static void main(String[] args) {
        EqualsAndHashcode equalsAndHashcode1 = new EqualsAndHashcode();
        equalsAndHashcode1.setAge(12);
        equalsAndHashcode1.setName("zhaoxu");

        SubEqualsAndHashcode subEqualsAndHashcode1 = new SubEqualsAndHashcode();
        subEqualsAndHashcode1.setAge(12);
        subEqualsAndHashcode1.setName("zhaoxu");
        boolean a= subEqualsAndHashcode1.equals(equalsAndHashcode1);
        boolean b= equalsAndHashcode1.equals(subEqualsAndHashcode1);
        System.out.println(b);

        //instanceof测试
        EqualsAndHashcode q =null;
        boolean c = q instanceof SubEqualsAndHashcode;
        System.out.println(c);
    }
}
