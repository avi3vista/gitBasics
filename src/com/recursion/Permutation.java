package com.recursion;

public class Permutation {

	public static void main(String[] args) {
		
		String input = "1234";
		
		char[] inputArr = input.toCharArray();
		
		printPermutation(inputArr, 0);

	}

	private static void printPermutation(char[] inputArr, int i) {
		if(i==inputArr.length) {
			System.out.println(String.valueOf(inputArr));
		}
		
		for(int index =i; index<inputArr.length; index++) {
			swap(inputArr, i, index);
			
			if((Character.getNumericValue(inputArr[index])%2) !=((i+1)%2))			
			printPermutation(inputArr, i+1);
			
			swap(inputArr, index, i);
			
		}
		
	}

	private static void swap(char[] inputArr, int i, int index) {
		char temp = inputArr[i];
		inputArr[i] = inputArr[index];
		inputArr[index] = temp;
		
	}

}
