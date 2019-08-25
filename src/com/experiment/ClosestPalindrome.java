package com.experiment;

public class ClosestPalindrome {

	public static void main(String[] args) {
		String n = "12345678";
		String result = "";
		if(isPalindrome(n)) {
			String lowerNumber = lowerPalindrome(n);
			String upperNumber = upperPalindrome(n);
			
			result = Long.parseLong(upperNumber)-Long.parseLong(n)>Long.parseLong(n)-Long.parseLong(lowerNumber) ? lowerNumber : upperNumber;
			
		}
		
		System.out.println("result = " + result);
		
	}

	private static String upperPalindrome(String n) {
		StringBuffer result = new StringBuffer();
		result.append(n.substring(0,(n.length()+1)/2));
		
		System.out.println("result = " + result);
		return null;
	}

	private static String lowerPalindrome(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isPalindrome(String n) {
		// TODO Auto-generated method stub
		return true;
	}
}
