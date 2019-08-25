package com.array;

public class MaxSumSubArray {

  public static void main(String[] args) {
    
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));

  }
  
  public static int maxSubArray(int[] nums) {
    if(nums==null || nums.length==0) {
      return 0;
    }
    
    if(nums.length==1) {
      return nums[0];
    }
    
    int curSum = nums[0];
    int maxSum = nums[0];
    
    for(int i=1; i<nums.length; i++) {
      if(curSum<=0) {
        curSum = nums[i];
      }
      else {
        curSum+=nums[i];
      }
      maxSum = Math.max(maxSum, curSum);
    }
    
    return maxSum;
  }

}
