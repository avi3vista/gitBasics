package com.adhoc;

public class MaxSumSubArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		
		findMaxSumSubArrayBruteForce(arr);

	}

	private static void findMaxSumSubArrayBruteForce(int[] arr) {
		int maxSum = 0;
		int maxSt = 0;
		int maxEd = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				int currSum = 0;
				for(int k=i; k<=j; k++) {
					currSum+=arr[k];
				}
				if(currSum>maxSum) {
					maxSum=currSum;
					maxSt = i;
					maxEd=j;
				}
			}
		}
		
		System.out.println("max Sum = " + maxSum + "  maxst = " + maxSt + "  maxEd = " + maxEd);
		
	}

}
