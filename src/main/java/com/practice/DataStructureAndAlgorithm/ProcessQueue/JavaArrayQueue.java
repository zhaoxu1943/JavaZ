package com.practice.DataStructureAndAlgorithm.ProcessQueue;

/**
 * 队列的数组实现
 * 相比较于链表队列,稍稍有一些区别
 * 用数组实现时
 * 如图,为了入队操作的方便
 * 把队尾位置规定为最后入队元素的下一个位置,即第一个空位 为队尾
 *
 * 队                队
 * 头                尾
 * ♦ ♦ ♦ ♦ ♦ ♦ ♦ ♦ ♦ ♢
 *
 * 对于入队操作,同链表队列相似,放入最后的空位即可
 *
 * 对于出队操作,由于链表队列是无限的,数组分配空间固定
 * 对于数组来说,如果不断出队,且无其他操作
 * 那么队内空间越来越小,队头越来越向队尾移动
 *
 * 此时我们可以使用循环队列 维持队列数量的恒定
 *
 * 循环队列充分的利用的数组的空间,避免了整体移动
 * 入队出队时间复杂度均为O(1)
 * @author zhaoxu
 * @className JavaArrayQueue
 * @projectName JavaConcentration
 * @date 2020/9/25 12:06
 */
public class JavaArrayQueue implements JavaQueue{


    /**
     * 内部存储-数组
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private int[] storageArr;

    /**
     * 队头下标
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private int frontIndex;


    /**
     * 队尾下标
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private int rearIndex;

    /**
     * 构造函数
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public JavaArrayQueue(int capacity) {
        storageArr = new int[capacity];
        frontIndex = 0;
        rearIndex = 0;
    }

    /**
     * 队列的基本操作
     * 入队判队满
     *
     * @param element
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public void enQueue(int element) {
        if ((rearIndex+1)%storageArr.length==frontIndex){
            throw new IllegalStateException("队列满!");
        }else{
            //进行正常插入
            storageArr[rearIndex] = element;

            //对数组取模,前进一个循环bucket
            rearIndex=(rearIndex+1)%storageArr.length;
        }
    }

    /**
     * 出队判队空
     *
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public int deQueue() {
        int front;
        if (rearIndex==frontIndex) {
            throw new IllegalStateException("队列空");
        }else{
            front =  storageArr[frontIndex];
            //对数组取模,前进一个循环bucket
            frontIndex=(frontIndex+1)%storageArr.length;
        }
        return front;
    }

    /**
     * 打印队列
     *
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public void printQueue() {
        for (int i = frontIndex; i !=rearIndex ; i=(i+1)%storageArr.length) {
            System.out.println(storageArr[i]);
        }
    }

    /**
     * 循环队列的测试
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void main(String[] args) {
        JavaArrayQueue queue  = new JavaArrayQueue(5);
        System.out.println("--------------进行循环队列入队测试-----------");
        queue.enQueue(1);
        queue.enQueue(32);
        queue.enQueue(321);
        queue.enQueue(213);
        queue.printQueue();
        //queue.enQueue(1321);
        System.out.println("--------------进行循环队列出队测试-----------");
        System.out.println("出队元素:"+queue.deQueue());
        System.out.println("出队元素:"+queue.deQueue());
        queue.printQueue();
        queue.enQueue(8888878);
        queue.printQueue();
    }












}
