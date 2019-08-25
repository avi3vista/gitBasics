package com.experiment;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
	public static void main(String[] args) {
		
		int[] givenNumbers = new int[] {2,7,11,15};
		int target = 9;
		int [] solutionNumbers = new int[2];
		
		solutionNumbers = returnSolutionHashMap(givenNumbers,target);
		if(solutionNumbers!=null) {
			System.out.println(solutionNumbers[0] + "   " + solutionNumbers[1]);
		}
		else {
			System.out.println("Not found");
		}
	}
	
	public static int[] returnSolutionHashMap (int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
		return null;
	}

}
