package com.string;

public class ClosestPalindrome {

	public static void main(String[] args) {

		String n = "10001";

		System.out.println(nearestPalindromic(n));

	}

	public static String nearestPalindromic(String n) {
		char[] charArr = n.toCharArray();
		
		if(isPalindrome(charArr)) {
			int mid= charArr.length/2;
			charArr[mid] = Character.forDigit((Character.getNumericValue(charArr[mid])-1),10);
			if(charArr.length%2==0) {
				charArr[mid-1] = Character.forDigit((Character.getNumericValue(charArr[mid-1])-1),10);
			}
		}
		else {
			for(int i=0; i<charArr.length/2; i++) {
				charArr[charArr.length-1-i] = charArr[i];
			}
		}
		
		
		return new String(charArr);
		

	}

	private static boolean isPalindrome(char[] charArr) {
		boolean res = true;
		
		for(int i=0; i<charArr.length/2; i++) {
			if(charArr[i]!=charArr[charArr.length-1-i]) {
				res=false;
				break;
			}
		}
		
		
		return res;
	}

}
