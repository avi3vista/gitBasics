package com.algorithms;

public class LinearSearch {
	
	public static void main(String[] args) {
		int[] inputArray = {1,2,3,4,5,6,7,8};
		
		int position = linearSearch(inputArray, 5);
		System.out.println("the position of the inputString is " + position);
		
		
	}

	private static int linearSearch(int[] inputArray, int searchNumber) {
		int position = -1;
		
		for (int i=0; i<inputArray.length-1; i++) {
			if(inputArray[i]==searchNumber) {
				return i;
			}
		}
		
		System.out.println("Input number not found");
		return position;
		
	}

}
