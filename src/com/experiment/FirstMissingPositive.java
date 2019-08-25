package com.experiment;

import java.util.Arrays;
import java.util.HashMap;

public class FirstMissingPositive {

	public static void main(String[] args) {
		
		//int[] nums = {4,7,1,2,1,2,0};
		
		int[] nums = {3,4,-1,1};
		//int[] nums={1,2,0};
		
		
		System.out.println("The result is " + firstMissingPositive(nums));

	}
	
	public static int firstMissingPositive(int[] nums) {
		int result =1;
		HashMap<Integer,Integer> resultMap = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0 && !resultMap.containsKey(nums[i])) {
				resultMap.put(nums[i], nums[i]);
			}
		}
		System.out.println("resultMap = " + resultMap);
		for(int i=1;i<=nums.length;i++) {
			if (resultMap.containsKey(i)) {
				result++;
			}
			else {
				return result;
			}
		}
		
		return result;
    }

}
