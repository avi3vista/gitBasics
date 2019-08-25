package com.experiment;

import java.util.Arrays;
import java.util.stream.Stream;

public class RotateArray {

	public static void main(String[] args) {
		
		int[] inputArray = new int[]{1,2,3,4,5,6,7};
		for (int i : inputArray) {
			//System.out.print(i);
		}
		
		int rotate = 2;
		rotate(inputArray,rotate);
		for (int i : inputArray) {
			//System.out.print(i);
		}

	}

	private static void rotate(int[] inputArray, int rotate) {
		
	rotate = rotate%inputArray.length;
		
		int[] tempArray = Arrays.copyOfRange(inputArray, 0, rotate);
		
		for(int i=0; i<inputArray.length-rotate; i++) {
			inputArray[i]=inputArray[i+rotate];
		}
		
		for(int i=0;i<tempArray.length;i++) {
			inputArray[inputArray.length-rotate+i]=tempArray[i];
		}
		for (int i : inputArray) {
			System.out.print(i);
		}

		
	}

}
