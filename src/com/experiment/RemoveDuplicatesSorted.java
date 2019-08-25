package com.experiment;

public class RemoveDuplicatesSorted {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 2, 2, 4, 5, 6, 6, 7, 8, 9, 11 };
		int length = removeDuplicates(nums);

		System.out.println("length = " + length);

		for (int i = 0; i < length; i++) {
			System.out.print(nums[i] + "	");
		}

		System.out.println();

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "	");
		}

	}

	public static int removeDuplicates(int[] nums) {
		int pointer = 1;
		if (nums.length < 2) {
			return nums.length;
		}
		int temp = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[pointer - 1]) {
				temp = nums[i];
				nums[i] = nums[pointer];
				nums[pointer] = temp;
				pointer++;
			}
		}
		return pointer;
	}

}
