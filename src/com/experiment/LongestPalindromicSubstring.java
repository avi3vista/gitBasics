package com.experiment;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "cbbd";
		
		System.out.println(longestPalindrome(input));

	}

	public static String longestPalindrome(String s) {
		
		String result = "";
		int maxLength = 0;
		
		for(int i=0; i<s.length(); i++) {
			for(int j=s.length(); j>i; j--) {
				if(j-i <= maxLength) {
					break;
				}
				if(isPalindrome(s.substring(i, j))) {
					if ((j-i) > maxLength) {
						maxLength = j-i;
						result = s.substring(i, j);
					}
				}
			}
		}
		
		
		return result;

	}

	private static boolean isPalindrome(String substring) {
		
		boolean isPalindrome = true;
		
		for(int i=0; i<substring.length()/2 ; i++) {
			if(substring.charAt(i)!=substring.charAt(substring.length()-1-i)) {
				isPalindrome=false;
				break;
			}
		}
		return isPalindrome;
	}

}
