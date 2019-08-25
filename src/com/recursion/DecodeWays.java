package com.recursion;

public class DecodeWays {

	public static void main(String[] args) {
		
		String input = "101";
		
		System.out.println("The number of ways it can be decode is " + numDecodings(input));

	}

	private static int numDecodings(String input) {
		int[] count = new int[1];
		
		int index=0;
        if(Integer.parseInt(input.substring(index, index+1))>0){
            decodeRecursive(input, index, count);    
        }
		
		return count[0];
		
	}

	private static void decodeRecursive(String input, int index, int[] count) {
		
		if(index>=input.length()) {
			count[0]++;
			return;
		}
		if(Integer.parseInt(input.substring(index, index+1))>0)
		decodeRecursive(input, index+1, count);
		
		if(index<input.length()-1 && Integer.parseInt(input.substring(index, index+2))<=26 && Integer.parseInt(input.substring(index, index+2))>0
				&& Integer.parseInt(input.substring(index, index+1))>0) {
			decodeRecursive(input, index+2, count);
		}
		
	}

}
