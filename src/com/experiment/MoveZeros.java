package com.experiment;

public class MoveZeros {

	public static void main(String[] args) {
		
		int[] nums = new int[] {1,0,2,3,4,0,5,6,0,7,8};
		moveZeroes(nums);
	}
	 public static void moveZeroes(int[] nums) {
		int slowPointer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[slowPointer] = nums[i];
				slowPointer++;
			}
		}
		for (int i = slowPointer; i < nums.length; i++) {
			nums[i] = 0;
		}

		return;
	}

}
