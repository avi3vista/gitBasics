package com.dynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {
		String s="BALL";
		String t = "CAR";
		
		System.out.println(editDistance(s,t));
		
		System.out.println(editDistanceDP(s,t));

	}

	private static int editDistanceDP(String s, String t) {
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		int[][] memo = new int [c1.length+1][c2.length+1];
		for (int i=memo.length-1; i>=0; i--) {
			memo[i][memo[i].length-1]=memo.length-1-i;
		}

		for(int j=memo[0].length-1; j>=0; j--) {
			memo[memo.length-1][j]=memo[0].length-1-j;
		}
		for(int i=memo.length-2; i>=0; i--) {
			for (int j=memo[i].length-2; j>=0; j--) {
				if (c1[i]==c2[j]) {
					memo[i][j] = memo[i+1][j+1];
				}
				else {
					memo[i][j] = 1 + Math.min(memo[i+1][j], Math.min(memo[i][j+1], memo[i+1][j+1]));
				}
			}
		}
		return memo[0][0];
		
	}

	private static int editDistance(String s, String t) {
		return (editDistance(s.toCharArray(), t.toCharArray(), t, 0, 0));
	}

	private static int editDistance(char[] charArray, char[] charArray2, String t, int i1, int i2) {
		if(i2>=charArray2.length) {
			return charArray.length-i1;
		}
		if(i1>=charArray.length) {
			return charArray2.length-i2;
		}
		if(charArray[i1]==charArray2[i2]) {
			return editDistance(charArray, charArray2, t, i1+1, i2+1);
		}
		int insert = editDistance(charArray, charArray2, t, i1, i2+1);
		int replace = editDistance(charArray, charArray2, t, i1+1, i2+1);
		int delete = editDistance(charArray, charArray2, t, i1+1, i2);
		
		
		return 1+(Math.min(insert, Math.min(replace, delete)));
		
		
		
		
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
