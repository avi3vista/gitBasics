package com.dynamicProgramming;

public class UniquePathII {

	public static void main(String[] args) {
		int n = 3;
		int m = 3;
		int[][] grid = new int[n][m];
		grid[1][1] = 1;
		printMatrix(grid);
		System.out.println(countPathsDP(grid));
	}

	public static int countPathsDP(int[][] obstacleGrid) {

		int[][] grid = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
		if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
			return 0;
		}
		for (int i = 0; i < grid.length; i++) {

			grid[i][grid[0].length - 1] = 0;

		}
		for (int i = 0; i < grid[0].length; i++) {

			grid[grid.length - 1][i] = 0;

		}
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					grid[i][j] = 1;
				}
			}
		}

		if (grid[grid.length - 2][grid[0].length - 2] != 1) {
			grid[grid.length - 2][grid[0].length - 2] = -1;
		}
		printMatrix(grid);
		for (int i = grid.length - 2; i >= 0; i--) {
			for (int j = grid[i].length - 2; j >= 0; j--) {
				if (i == grid.length - 2 && j == grid[i].length - 2) {
					continue;
				}
				if (grid[i][j] != 1 && grid[i + 1][j] == 1) {
					grid[i][j] = grid[i][j + 1];
				} else if (grid[i][j] != 1 && grid[i][j + 1] == 1) {
					grid[i][j] = grid[i + 1][j];
				} else if (grid[i][j] != 1) {
					grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
				}
			}
		}

		printMatrix(grid);

		if (grid[0][0] != 1) {
			return -grid[0][0];
		}
		return 0;
	}

	public static void printMatrix(int[][] grid) {
		System.out.println("======================================");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("======================================");
	}

}
