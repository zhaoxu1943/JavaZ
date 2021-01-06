package com.practice.DataStructureAndAlgorithm.ProcessArray;

/**
 * 数组的超范围插入
 * @author zhaoxu
 * @className ResizeInsertArray
 * @projectName JavaConcentration
 * @date 2020/9/16 9:40
 */
public class ResizeInsertArray {

    private int[] arr;
    private int size;

    public ResizeInsertArray(int capacity) {
        arr = new int[capacity];
        size=0;
    }

    /**
     * 超范围插入
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public void insert(int index,int element) {
        //第一步还是判断下标,限定前中后插入
        if (index<0||index>size){
            throw  new IndexOutOfBoundsException("超过数组实际范围!");
        }

        //如果数组元素达到了容量上限,则进行扩容
        if (size>=arr.length){
            resize();
        }

    // 重复之前的中间插入,从后向前移位
    for (int i = size-1; i >= index; i--) {
     arr[i+1] = arr[i];
    }
    arr[index] = element;
    size++;

    }


    /**
     * 数组扩容
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private void resize(){
        //新的数组,容量为原来2倍
        int[] resizeArr = new int[arr.length*2];
        //进行数组的复制
        //这里范围是arr.length,因为size 可能大于实际元素了
        System.arraycopy(arr,0,resizeArr,0,arr.length);
        //扩容完毕
        arr= resizeArr;
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

  public static void main(String[] args) {
    ResizeInsertArray array = new ResizeInsertArray(3);
    array.insert(0,1);
      array.insert(1,2);
      array.insert(2,3);
      array.insert(1,5321);
      array.printArr();
  }
}
