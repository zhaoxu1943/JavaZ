package com.practice.DataStructureAndAlgorithm.leetcode;

import java.util.*;

/**
 * @author zhaoxu
 * @className TopKFrequent
 * @projectName JavaConcentration
 * @date 2020/9/14 13:48
 */
public class TopKFrequent_347 {

    /**
     *  my solution : hashMap and
     *  Array.sort
     *
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        //use hashmap
        Map<Integer,Integer> timesMap = new HashMap<>();
        for (int i:nums) {
            if (timesMap.containsKey(i)){
                timesMap.put(i,timesMap.get(i)+1);
            }else {
                timesMap.put(i,1);
            }
        }
        //对map进行排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(timesMap.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        // 输出前k
        for (int i = 0; i < k; i++ ){
            result[i]=list.get(i).getKey();
        }
        return  result;
    }

    /**
     * 官方题解
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] m, int[] n) {
                    return m[1] - n[1];
                }
            });
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (queue.size() == k) {
                    if (queue.peek()[1] < count) {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                } else {
                    queue.offer(new int[]{num, count});
                }
            }
            int[] ret = new int[k];
            for (int i = 0; i < k; ++i) {
                ret[i] = queue.poll()[0];
            }
            return ret;
        }
    }


}
