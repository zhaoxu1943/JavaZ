package com.practice.DataStructureAndAlgorithm.ProcessQueue;

/**
 * 队列接口
 * → → → → → → → → → → →
 * 入口端:队尾 ♢-♢-♢-♢-♢-♢-♢-♢ 出口端:队头
 * 生活模型:高速公路上的单行隧道
 * 仅仅允许一端进入,一端驶出,不允许逆行
 * 即FIFO
 *
 * 与栈类似,队列既可以使用Array实现,也可以使用LinkedList实现
 * @author zhaoxu
 * @className JavaQueue
 * @projectName JavaConcentration
 * @date 2020/9/21 14:59
 */
public interface JavaQueue {


    /**
     * 队列的基本操作
     * 入队
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    void enQueue(int element);



    /**
     * 出队
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    int  deQueue();

    /**
     * 打印队列
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    void printQueue();

}
