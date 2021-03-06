package com.experiment;

public class BitOperator {

	public static void main(String[] args) {
		
		
		// Input: N = 10000000000, M = 10101, i = 2, j = 6
		 //Output: N = 10001010100
		int n=1024;
		int m=21;
		int i=2;
		int j=6;
		
		System.out.println(updateBits(n,m,i,j));

	}
	
	public static int updateBits(int n, int m, int i, int j) {
		// create a mask to clear bits i through j in n
		// Example: i=2, j=4, result should be 11100011
		// for simplicity, we'll use just 8 bits for the example
		int allOnes = ~0; // will equal sequence of all 1s
		int left = allOnes << (j + 1); // left: 11100000
		int right = ((1 << i) - 1); // right:00000011
		int mask = left | right; // mask: 11100011
		// clear bits j through i then put m in there
		int n_cleared = n & mask; // clear bits j through i
		int m_shifted = m << i; // move m into correct position
		return (n_cleared | m_shifted);
	}

}
