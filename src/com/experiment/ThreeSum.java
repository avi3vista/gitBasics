package com.experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,5,4,3,2,1,-1,-2,-4,-2,-7,-4};
		
		System.out.println(threeSum(nums));
	}	
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result;
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        int target =0;
        if(nums.length <3) {
        	result = new ArrayList<List<Integer>>();
        	return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
        	int sum = nums[i];
        	int lowIndex = i+1;
        	int highIndex = nums.length-1;
        	
        	while(lowIndex<highIndex) {
        		if(sum+nums[lowIndex]+nums[highIndex]>target) {
        			highIndex--;
        		}
        		else if(sum+nums[lowIndex] + nums[highIndex]<target) {
        			lowIndex++;
        		}
        		else {
        			List<Integer> tempList = new ArrayList<Integer>();
        			tempList.add(nums[i]);
        			tempList.add(nums[lowIndex]);
        			tempList.add(nums[highIndex]);
        			resultSet.add(tempList);
        			lowIndex++;
        			highIndex--;
        		}
        	}
        	
        }
        
        result = new ArrayList<List<Integer>>(resultSet);
        
        return result;
    }
}
