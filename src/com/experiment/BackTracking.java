package com.experiment;

import java.util.Arrays;

public class BackTracking {

	static int[] A = new int[2];
	
	public static void main(String[] args) {

		
		Binary(2);
		
	}

	private static void Binary(int n) {

		if( n<1)
			System.out.println(Arrays.toString(A));
		else
		{
			A[n-1]=0;
		Binary(n-1);
		A[n-1]=1;
		Binary(n-1);
		}
		
	}

}
