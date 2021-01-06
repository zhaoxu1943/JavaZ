package com.practice.DataStructureAndAlgorithm;

//字母异位次问题
public class ContainSameWordProblem {
    public static void main(String[] args) throws Exception{
        String str1 = "zhaoxu";
        String str2 = "xuzhao";


        System.out.println(containSameWordsOne(str1,str2));

        System.out.println(containSameWordsTwo(str1,str2));

        //这里不用new 就生成了Integer对象 是谓自动装箱
        Integer i  = 19;

        //int和String的互相转化
        String s = i.toString();



        //装箱使用了包装类的valueof
        int o = Integer.valueOf(s);
        //拆箱使用了xxxValue  xxx为基础数据类型
        int a = i.intValue();



        //这里将Integer类型的对象 直接转为基础数据类型  可谓自动拆箱
        int n = i;
        System.out.println(n);
        System.out.println(s);



    }


    //核心思想是当一个char类型 如 int i = 'a' 赋值给int时,自动转换为int型,值为其unicode码
    //而且unicode码是唯一的,所以可以唯一的确定包含的字母相同
    public static boolean containSameWordsOne (String str1, String str2) {
        boolean flag =false;
        //定义和
        int sumStr1 =0;
        int sumStr2 =0;
        //都转化为小写
        str1.toLowerCase();
        str2.toLowerCase();
        //String的toCharArray()方法直接将String转化为char的数组
        char[] str1charArr =  str1.toCharArray();
        char[] str2charArr =  str2.toCharArray();
        //首先确定包含的字符长度相等,否则直接返回false
        if (str1charArr.length==str2charArr.length){
            for (int i=0;i<str1charArr.length;i++)
            {
                //运算将char元素赋值给int,值为unicode码
                sumStr1 = sumStr1 + str1charArr[i];
                sumStr2 = sumStr2 + str1charArr[i];
            }
            if (sumStr1==sumStr2){
                flag = true;
            }
        }else {
            flag = false;
        }
            return flag;
    }



    public static boolean containSameWordsTwo(String str1,String str2) throws Exception {
        //得到Byte数组
        //ASCII字符集
        //共收录128个字符，包括空格、标点符号、数字、大小写字母和一些不可见字符。
        // 由于总共才128个字符，所以可以使用1个字节来进行编码
        //ISO 8859-1字符集
        //共收录256个字符，是在ASCII字符集的基础上又扩充了128个西欧常用字符(包括德法两国的字母)，
        // 也可以使用1个字节来进行编码。这个字符集也有一个别名latin1。
        //GB2312字符集
        //收录了汉字以及拉丁字母、希腊字母、日文平假名及片假名字母、
        // 俄语西里尔字母。其中收录汉字6763个
        //GBK字符集(win10默认)
        //GBK字符集只是在收录字符范围上对GB2312字符集作了扩充，编码方式上兼容GB2312。
        //utf8字符集(linux默认)
        //收录地球上能想到的所有字符，而且还在不断扩充。这种字符集兼容ASCII字符集，采用变长编码方式，编码一个字符需要使用1～4个字节，比方说这样：

        //由于getBytes不指定参数时,会得到其每个字符默认编码组成的数组,所以最好指定参数
        byte[] bytes1 = str1.toUpperCase().getBytes("utf-8");
        byte[] bytes2 = str2.toUpperCase().getBytes("utf-8");

        //接着讲Byte数组转为新的字符串
        String newString = new String(bytes1,"utf-8");
        System.out.println("newString = " +newString);

        for (byte b:bytes1) {
            System.out.println(b);
        }
        boolean b= false;
        int s1 = 0;
        int s2 = 0;
        for (byte b1:bytes1) {
            s1 += b1;
        }
        for (byte b1:bytes1) {
            s2 += b1;
        }
        System.out.println(s2);
        if (s1 == s2) {
            b =true;
        }else {
            b=false;
        }

        return b;
    }


}
