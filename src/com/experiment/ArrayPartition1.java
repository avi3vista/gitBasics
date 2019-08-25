package com.experiment;

import java.util.Arrays;

public class ArrayPartition1 {

	public static void main(String[] args) {
		
		int[] inputArray = {4,3,2,1};
		
		System.out.println("minimum is " + findMinimum(inputArray));

	}

	private static int findMinimum(int[] inputArray) {
		int result = 0;
		Arrays.sort(inputArray);
		
		for(int i=0;i<inputArray.length;i=i+2) {
			result = result + Integer.min(inputArray[i],inputArray[i+1]);
		}
		
		return result;
	}

}
