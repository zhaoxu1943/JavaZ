package com.readbooks.Algorithms4th;

/**
 * 简简单单写个二分
 * @author zhaoxu
 * @className BinarySearch
 * @projectName JavaConcentration
 * @date 2021/3/3 9:27
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]) {
                low  = mid+1;
            }else if(target<nums[mid]) {
                high=mid-1;
            }
        }
        return -1;
    }

  public static void main(String[] args) {
    //

      int[] arr = new int[]{-1,0,3,5,9,12};
      int target = 679;
      BinarySearch binarySearch = new BinarySearch();
     System.out.println(binarySearch.binarySearch(arr,target));

  }
}
