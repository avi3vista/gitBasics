package com.dynamicProgramming;

public class UniqueBST {

	public static void main(String[] args) {
		int n=5;
		
		for(int i=1; i<=n; i++) {
			System.out.println(numTrees(i));
		}

	}

	private static int numTrees(int i) {
		int[] memo = new int[i+1];
		memo[0]=1;
		memo[1]=1;
		
		for(int k=2; k<=i; k++) {
			int temp=0;
			for(int j=1; j<=k; j++) {
				temp+=memo[j-1]*memo[k-j];
			}
			memo[k]=temp;
		}
		
		return memo[i];
		
	}

}
