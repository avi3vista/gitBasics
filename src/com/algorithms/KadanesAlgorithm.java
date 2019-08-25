package com.algorithms;

public class KadanesAlgorithm {
	public static void main(String[] args) {
		
		int[] nums = {4,-3,-2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		
		int maxSum = nums[0];
		int curSum = nums[0];
		for(int i=1; i<nums.length; i++) {
			curSum = Math.max(nums[i], curSum+nums[i]);
		
			if (curSum>maxSum) {
				maxSum=curSum;
			}
		}
		
		
		/*int maxSum, curSum;

		curSum = maxSum = nums[0];

        for (int i = 1; i < nums.length; ++i) {
        	curSum = nums[i] > nums[i] + curSum ? nums[i] : nums[i] + curSum;
        	maxSum = curSum > maxSum ? curSum : maxSum;
        }*/
		
		System.out.println("max sum = " + maxSum);

	}
}
