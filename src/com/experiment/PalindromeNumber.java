package com.experiment;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		long input = 807045053224792883L;
		long addition = 0L;
		long result;
		while (true) {
			if(isPalindrome(input-addition)) {
				result = input-addition;
				break;
			}
			else if(isPalindrome(input+addition)) {
				result = input+addition;
				break;
			}
			addition++;
		}
		
		System.out.println(result);
		
	}

	private static boolean isPalindrome(long input) {
		boolean isPalindrome = true;
		long divisor = 1;
		long temp = input;
		
		while(temp>=10) {
			divisor *=10;
			temp= temp/10;
		}
		
		while(input>=1) {
			if(input/divisor != input%10) {
				isPalindrome = false;
				break;
			}
			input = input%divisor;
			input = input/10;
			divisor = divisor/100;
		}
		
		
		return isPalindrome;
		
	}

}
