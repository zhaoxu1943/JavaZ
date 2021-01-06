package com.practice.DataStructureAndAlgorithm.ProcessArray;

/**
 * @author zhaoxu
 * @className MidInsertArray
 * @projectName JavaConcentration
 * @date 2020/9/10 12:46
 */
public class MidInsertArray {

    private int[] arr;
    private int size;

    public MidInsertArray(int capacity) {
        this.arr = new int[capacity];
        size=0;
    }


    /**
     *
     * 中间插入
     * insert to array
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private  void midInsertArray(int index,int element) {
        //数组处理第一步,判断下标,等于是可以的,比如说
        //当前数组有5个元素,下标0-4,此时插入下标为5的元素
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException("超出数据实际元素范围");
        }
        //此时进行从index开始,所有位置的后移,后插入,假设数组范围够大
        //循环后移,不能从前往后,只能从后往前,因为从前往后会覆盖元素
        //从后往前只会占用数组空闲空间
        //这里从后往前,逐个后移,范围为从 数组最后一个实际元素的下标,到将插入的位置
        //终止条件是,数组最后一个实际元素的下标=到将插入的位置下标,若此时无实际元素,
        //下标不存在为 -1,不会触发移位操作
        for (int i = size-1; i >= index; i--) {
            arr[i+1]= arr[i];
        }
        arr[index] = element;
        //最后元素要自增
        size++;

    }








    public static void main(String[] args) {
        //初始容量为10
        MidInsertArray array = new MidInsertArray(10);
        array.midInsertArray(0,3);
        array.midInsertArray(0,2);
        array.midInsertArray(1,7);
        array.midInsertArray(2,9);
        array.midInsertArray(3,5);
        array.printArr();

    }


    /**
     * 打印
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public void printArr() {
        for (int i : arr ) {
      System.out.println(i);
        }
    }
}
