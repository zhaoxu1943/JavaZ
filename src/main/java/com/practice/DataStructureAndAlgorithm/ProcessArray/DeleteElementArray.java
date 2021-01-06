package com.practice.DataStructureAndAlgorithm.ProcessArray;

/**
 * 数组元素的删除
 * 不涉及扩容问题,所以进行删除,左移覆盖即可
 * 时间复杂度为O(N)
 * @author zhaoxu
 * @className DeleteElementArray
 * @projectName JavaConcentration
 * @date 2020/9/16 9:59
 */
public class DeleteElementArray {
    private int[] arr;
    private int size;

    public DeleteElementArray(int capacity) {
        arr = new int[capacity];
        size=0;
    }

    /**
     * 数组元素删除
     * @author zhaoxu
     * @param index 删除元素的位置
     * @return int 删除的元素
     * @throws
     */
    public int deleteElement(int index) {
        int deleteValue = 0;
        //这里等于size 也不行
        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("数组下标越界!");
        }else {
            deleteValue = arr[index];
            if (index == size-1) {
                //尾部删除
                arr[index] = 0;
            }else{
                //中间删除与头部删除,这里是size-1,可执行最大为size-2,检验方法
                //循环体中有 i,i+1,当size-2 时 i+1 等于 size-1 ,已达到下标极限,再大就越界了
                for (int i = index; i < size-1; i++) {
                    arr[i]=arr[i+1];
                }
            }
        }
        size--;
        return deleteValue;

    }





    /**
     * 小灰
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */


    public int delete(int index)  {
        //判定下标
        if (index<0||index>=size) {
            throw new  IndexOutOfBoundsException("超出数组实际元素范围!");
        }
        int  deletedElement = arr[index];
    // 从左向右循环
    for (int i = index; i < size-1; i++) {
      //
        arr[i] =  arr[i+1];
    }
    size--;
    return deletedElement;
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
        DeleteElementArray array = new DeleteElementArray(3);
        array.insert(0,1);
        array.insert(1,2);
        array.insert(2,3);
        array.insert(1,5321);
        array.printArr();
        System.out.println(array.size);
        System.out.println("开始删除");
        System.out.println("删除了:"+array.delete(3));
        array.printArr();
    }

}
