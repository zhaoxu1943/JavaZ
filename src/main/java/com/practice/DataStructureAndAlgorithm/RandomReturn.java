package com.practice.DataStructureAndAlgorithm;

/**
 * 随机返回
 * @author zhaoxu
 * @className RandomReturn
 * @projectName JavaConcentration

 * @date 3/14/2020 9:54 PM
 */
public class RandomReturn {
    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9};

        try {
            System.out.println(returnNum(nums));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static int returnNum(int[] nums) throws InterruptedException {
        final int[] returnNum = {0};
        //创建线程去执行
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //判断当前线程中断标志,被打断则停止轮训
                while (!Thread.currentThread().isInterrupted()){
                    //坚强的for循环 ,一定要执行完自己的代码,不管你interrupt!
                    for (int i:nums) {
                        returnNum[0] = i;
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();

        return returnNum[0];
    }





}
