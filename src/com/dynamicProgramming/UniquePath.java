package com.dynamicProgramming;

public class UniquePath {

	public static void main(String[] args) {
		int n=3;
		int m=4;
		 int[][] grid = new int[n][m];
			System.out.println(countPathsRec(grid, 0, 0));
			System.out.println(countPathsDP(grid));
	}
	
	public static int countPathsRec(int[][] grid, int r, int c) {
		
		if(r>=grid.length || c>=grid[0].length) {
			return 0;
		}
		if(r==grid.length-1 && c==grid[0].length-1) {
			return 1;
		}
		
		return countPathsRec(grid, r+1, c) + countPathsRec(grid, r, c+1);
		
	}
	
public static int countPathsDP(int[][] grid) {
		
	for(int i=0; i<grid.length; i++) {
		grid[i][grid[0].length-1]=1;
	}
	for(int i=0; i<grid[0].length; i++) {
		grid[grid.length-1][i]=1;
	}
	
	for(int i=grid.length-2; i>=0; i--) {
		for(int j=grid[i].length-2; j>=0; j--) {
			grid[i][j]=grid[i+1][j]+ grid[i][j+1];
		}
	}
		return grid[0][0];	
	}

}
