package com.experiment;

public class ReshapeMatrix {

	public static void main(String[] args) {

		int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 } };

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + "   ");
			}
			System.out.println();
		}

		int result[][] = matrixReshape(nums, 3, 2);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "   ");
			}
			System.out.println();
		}

	}

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if((nums.length==0) || (r*c != nums.length*nums[0].length)) {
			return nums;
		}
		int[][] result = new int[r][c];
		int currentRow = 0, currentCol = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				if (currentCol >= c) {
					currentCol = 0;
					currentRow++;
				}
				result[currentRow][currentCol++] = nums[i][j];
			}
		}

		return result;

	}

}
