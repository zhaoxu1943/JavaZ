package com.practice.DataStructureAndAlgorithm.search;

/**
 * 二分查找
 * 设数组长度为size 需要执行的次数为N
 * 那么 2^N>size即全覆盖
 * 即时间复杂度为
 * N = logSize
 * 即O(LogN)
 *
 * 分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节
 *
 * @author zhaoxu
 * @className BinarySearch
 * @projectName JavaConcentration
 * @date 2020/9/11 7:47
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,8,9,34};
        int searchNum = 543;
        System.out.println(binarySearch(searchNum,arr));
    }

    /**
     * 二分查找
     * @author zhaoxu
     * @param num 查找的元素
     * @param arr 查找的数组
     * @return int num所在索引
     */
    private static int binarySearch(int num,int[] arr) {
            //循环外声明变量
            int leftIndex = 0;
            int rightIndex = arr.length - 1;

            //最终结果为缩小到一个索引,即leftIndex=rightIndex
            //终止点2:当区间为空时(条件leftIndex>rightIndex,即区间不存在),还没找到,此时需要while循环去终止,并return -1
            while (leftIndex<=rightIndex) {
                //下标将向下取整,并防止整型溢出,所以这么写
                int midIndex = leftIndex+(rightIndex - leftIndex) / 2;
                int mid = arr[midIndex];
                //终止点1:找到目标值
                if (num == mid) {
                   return midIndex;
                } else if (mid<num) {
                    //中点值小于num,所以修改left
                    leftIndex = midIndex + 1;
                } else if (num<mid) {
                    //中点值大于num,则修改high
                    rightIndex = midIndex - 1;
                }
            }
           return -1;
        }



}
