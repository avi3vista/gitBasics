package com.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.eventbus.Subscribe;

public class SuperSet {

	public static void main(String[] args) {
		
		
		Set<String> res = new HashSet<String>();
		String input = "abcd";
		char[] prefix = new char[input.length()];
		printPrefix(prefix, input.toCharArray(), res,0,0);
		
		for(String s: res) {
		//	System.err.println(s);
		}
		
		int[] nums = {1,2,3};
		
		int target = 5;
		printSubSetSummingTarget(nums, target);
		
	//List<List<Integer>> resL = subsets(nums);
		

	}

	private static void printSubSetSummingTarget(int[] nums, int target) {
		int numIndex = 0;
		int[] prefix = new int[nums.length];
		int prefixIndex = 0;
		
		printSubSetSummingTargetRec(nums, prefix, numIndex, prefixIndex, target, 0);
	}

	private static void printSubSetSummingTargetRec(int[] nums, int[] prefix, int numIndex, int prefixIndex,
			int target, int currentSum) {
		
		if(numIndex>=nums.length || prefixIndex>=nums.length) {
			if(target==currentSum) {
			for(int s=0; s<prefixIndex; s++) {
				System.out.print(prefix[s]);
			}
			System.out.println();
			}
			return;
		}
		
		printSubSetSummingTargetRec(nums, prefix, numIndex+1, prefixIndex, target, currentSum);
		
		prefix[prefixIndex] = nums[numIndex];
		currentSum+=nums[numIndex];
		
		printSubSetSummingTargetRec(nums, prefix, numIndex+1, prefixIndex+1, target, currentSum);
		currentSum-=nums[numIndex];
		
		
	}

	private static void printPrefix(char[] prefix, char[] input, Set<String> res, int prefixIndex, int inputIndex) {
		
		if(inputIndex>=input.length) {
			res.add(new String(prefix, 0 , prefixIndex));
			return;
		}
		
		printPrefix(prefix, input, res, prefixIndex, inputIndex+1);
		prefix[prefixIndex]=input[inputIndex];
		printPrefix(prefix, input, res, prefixIndex+1, inputIndex+1);
		
		
		
	}
	
	 public static List<List<Integer>> subsets(int[] nums) {
		 int index=0;
		 Set<List<Integer>> res = new HashSet<List<Integer>>();
		 List<Integer> prefixList = new ArrayList<Integer>();
		 
		 populateSubSets(nums, index, res,prefixList);
		 
		 System.out.println(res);
		 return new ArrayList<List<Integer>>(res);
	 
	 }

	private static void populateSubSets(int[] nums, int index, Set<List<Integer>> res, List<Integer> prefix) {
		
		if(index>=nums.length) {
			List<Integer> prefixList = new ArrayList<Integer>(prefix);
			res.add(prefixList);
			return;
		}
		List<Integer> currentList = new ArrayList<Integer>(prefix);
		populateSubSets(nums, index+1, res, currentList);
		currentList.add(nums[index]);
		populateSubSets(nums, index+1, res, currentList);
		
		
	}
	 

}
