package com.recursion;

public class HowManyBST {

	public static void main(String[] args) {
		
		int n=4;
		System.out.println("The number of BST are  " + how_many_BSTs(n) );

	}
	
	 static long how_many_BSTs(int n) {
		 long res = 0;
		 
		 if(n==1) {
			 res=1;
		 }
		 if(n>1) {
			 res = countRec(n);
		 }
		 return res;

	    }

	private static long countRec(int n) {
		if(n<=1) {
			return 1;
		}
		int sum = 0;
		
		for(int i=1; i<=n;i++) {
			long left = countRec(i-1);
			long right = countRec(n-i);
			sum+=left*right;
		}
		
		return sum;
	}

}
