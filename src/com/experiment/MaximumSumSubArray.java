package com.experiment;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		
		int[] input = {-2,1,-3,4,-1,2,1,-5,4,10};
		
		System.out.println("Max subArray is " + maxSubArray(input));

	}

	private static int maxSubArray(int[] input) {
		
		int maxSum = 0;
		int p1 = 0;
		int p2 = 0;
		int current = 0;
		
		
		for(int i : input) {
			current = i+current;
			maxSum = Math.max(maxSum, current);
			if(current<0) {
				current = 0;
			}
		}
		
		return maxSum;
	}

}
