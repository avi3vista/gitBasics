package com.recursion;

public class CountPaths {

	public static void main(String[] args) {
		
		int[][] grid = new int[2][3];
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				System.out.print(grid[i][j]+ "  " );
			}
			System.out.println();
		}
		
		System.out.println("number of paths = " + countPaths(grid));

	}

	private static int countPaths(int[][] grid) {
		return countPathsRec(grid, 0, 0);
		
	}

	private static int countPathsRec(int[][] grid, int r, int c) {
		
		if(r>=grid.length || c>=grid[0].length) {
			return 0;
		}
		if(r==grid.length-1 && c==grid[0].length-1) {
			return 1;
		}
		
		return countPathsRec(grid, r+1, c) + countPathsRec(grid, r, c+1);
		
	}

}
