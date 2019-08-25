package com.dynamicProgramming;

public class CoinPlay {

	public static void main(String[] args) {
		
		int[] arr = {8,15,3,7};
		
		System.out.println(max(arr,0,3));

	}

	private static int max(int[] arr, int i, int j) {
		if(i>j) {
			return 0;
			
		}
		int left = arr[i];
		int right = arr[j];
		left+=max(arr, i+1, j);
		right+=max(arr,i,j-1);
		int result = Math.max(left, right);
		System.out.println("The result for iteration with i = " + i + "  j = " + j + "   =  " + result + "   left =  " + left + "  right = " + right);
		return result;
		
		
	}

}
