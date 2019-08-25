package com.experiment;

import java.util.HashMap;
import java.util.Map;

public class TrappingRainWater {

	public static void main(String[] args) {

		int[] inputArray = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		
		Map<Integer,Integer> leftMax = new HashMap<Integer,Integer>();
		Map<Integer, Integer> rightMax = new HashMap<Integer,Integer>();
		int max=0;
		leftMax.put(0, 0);
		for(int i=0;i<inputArray.length-1; i++) {
			if (inputArray[i]>max) {
				max=inputArray[i];
			}
			leftMax.put(i+1, max);
		}
		 max=0;
		for(int i=inputArray.length-1;i>=0; i--) {
			if (inputArray[i]>max) {
				max=inputArray[i];
			}
			rightMax.put(i, max);
		}
		System.out.println("leftMax = " + leftMax);
		System.out.println("rightMax = " + rightMax);
		int totalWater=0;
		int elementWater=0;
		for(int i=1;i<inputArray.length-1;i++) {
			elementWater=Integer.min(leftMax.get(i), rightMax.get(i))-inputArray[i];
			if(elementWater>0) {
				totalWater+=elementWater;
			}
		}
		
		System.out.println(totalWater);
		
	}

}
