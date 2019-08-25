package com.experiment;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

	public static void main(String[] args) {
		
		String s = "code";
		
		System.out.println("is Palindrome " + canPermutePalindrome(s));

	}

	public static boolean canPermutePalindrome(String s) {
		boolean isPalindrome = false;
		Set<Character> charSet = new HashSet<Character>();
		
		for(char c: s.toCharArray()) {
			if(charSet.contains(c)) {
				charSet.remove(c);
			}
			else {
				charSet.add(c);
			}
		}
		if(charSet.size()<2) {
			isPalindrome = true;
		}
		
		
		return isPalindrome;

	}

}
