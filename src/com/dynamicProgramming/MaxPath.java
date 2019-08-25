package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MaxPath {

	public static void main(String[] args) {
		
		int maxRows=4;
		int maxColumns=4;
		
		List<String> path = new ArrayList<String>();
		int[][] mat = {{10,5,31,27},
					   {43,81,47,52},
					   {55,24,91,37},
					   {71,63,6,7}};
		
		System.out.println(maxPathRecursive(mat,0,0));
		
		System.out.println(maxPathDP(mat,0,0));
		
		
		//traverse(0,0,maxRows,maxColumns,path);

	}

	private static int maxPathRecursive(int[][] mat, int cr, int cc) {
		if(cr>=mat.length || cc>=mat[0].length) {
			return 0;
		}
		if(cr==mat.length-1 && cc==mat[0].length) {
			return mat[cr][cc];
		}
		return mat[cr][cc]+ Math.max(maxPathRecursive(mat, cr+1, cc), maxPathRecursive(mat,cr, cc+1));
	}

	private static int maxPathDP(int[][] mat, int cr, int cc) {
		int[][] memo = new int[mat.length+1][mat[0].length+1];
		
		for(int i=0; i<memo.length; i++) {
			memo[i][memo[0].length-1]=0;
		}
		
		for(int i=0; i<memo[0].length; i++) {
			memo[memo.length-1][i]=0;
		}
		
		for(int i=memo.length-2; i>=0; i--) {
			for(int j=memo[i].length-2; j>=0; j--) {
				memo[i][j] = mat[i][j] + Math.max(memo[i+1][j], memo[i][j+1]);
			}
		}
		
		for(int i=0; i<memo.length; i++) {
			for(int j=0; j<memo[i].length; j++) {
				System.out.print(memo[i][j] + "  ");
			}
			System.out.println();
		}
		
		
		return memo[0][0];
	
	}

	private static void traverse(int currentRow, int currentCol, int maxRows, int maxColumns, List<String> path) {
		path.add("("+currentRow + "," + currentCol + ")");
		if(currentRow==maxRows && currentCol==maxColumns) {
			System.out.println(path);
		}
		else if(currentRow==maxRows) {
			traverse(currentRow, currentCol+1, maxRows, maxColumns, path);
		}
		else if(currentCol==maxColumns) {
			traverse(currentRow+1, currentCol, maxRows, maxColumns, path);
		}
		else {
			traverse(currentRow+1, currentCol, maxRows, maxColumns, path);
			traverse(currentRow, currentCol+1, maxRows, maxColumns, path);
			traverse(currentRow+1, currentCol+1, maxRows, maxColumns, path);
		}
		if(path.size()>=1) {
		path.remove(path.size()-1);
		}
		
	}

}
