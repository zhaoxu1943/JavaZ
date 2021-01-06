package com.practice.DataStructureAndAlgorithm.ProcessArray;

/**
 * 数组基础
 * 数组的初始化,包装类型,引用类型初始化为null
 * 而基础数据类型初始化为各自初始值
 * @author zhaoxu
 * @className ArrayBasicKnowledge
 * @projectName JavaConcentration
 * @date 2020/5/14 22:54
 */
public class ArrayBasicKnowledge {

    public static void main(String[] args) {
        //动态初始化方式一,默认数组中的元素都是0
        //数组中的元素被赋初始值
        Integer[] array = new Integer[5];
        printArray(array);

        Boolean[] arrayBoolean = new Boolean[4];
        printArray(arrayBoolean);

        ///动态初始化方式二，默认数组中的元素都是0
        Integer[]  array2 = new Integer[0];
        printArray(array2);
        
        System.out.println();
        Integer[] array1 = new Integer[]{1,2,3,6,7,3};
        printArray(array1);

        //多维
        Integer[][] array3 = new Integer[2][3];
        //printArray(array3);

    }










    /**
     * 泛型数组打印方法
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static <T> void printArray(T[] arr) {
        for (T t:arr) {
            System.out.print(t+" ");
        }
    }
}
