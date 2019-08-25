package com.array;

public class MaxProductSubArray {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxProduct(nums));

  }


  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Integer negCur = null;
    Integer posCur = null;
    Integer max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        negCur = 0;
        posCur = 0;
      } else {
        if (nums[i] < 0) {
          if (negCur != null) {
            posCur = negCur * nums[i];
          }
          negCur = nums[i];
        }
        if (nums[i] > 0) {
          if (negCur != null) {
            negCur = negCur * nums[i];
          }
          if (posCur != null) {
            posCur = posCur * nums[i];
          } else {
            posCur = nums[i];
          }


        }
      }
      if (posCur != null) {
        max = Math.max(max, posCur);
      }
      if (negCur != null) {
        max = Math.max(max, negCur);
      }

    }
    return max;

  }
}
