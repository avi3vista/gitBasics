package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class PalindromicDecomposition {

	public static void main(String[] args) {
		String input = "abracadabra";
		
	String[] res = generate_palindromic_decompositions(input);
	
	for(String s : res) {
		System.out.println(s);	}
		

	}
	
	static String[] generate_palindromic_decompositions(String s) {
		
		List<String> res = new ArrayList<String>();
		
		generatePalindromes(s, "", 0, res);
		
		return res.toArray(new String[0]);

    }

	private static void generatePalindromes(String s, String left, int index, List<String> res) {
		
		if(index>=s.length()) {
			res.add(left);
			return;
		}
		
		for(int i=index; i<s.length(); i++) {
			if(isPalindrome(s.substring(index, i+1))) {
				String newLeft = StringUtils.isEmpty(left) ? s.substring(index, i+1) : left+ "|"+s.substring(index, i+1);
				generatePalindromes(s, newLeft, i+1, res);
			}
		}
		
	}

	private static boolean isPalindrome(String input) {
		boolean isPal = true;
		 
		if(input==null || input.length()<2) {
			return isPal;
		}
		for(int i=0; i<input.length()/2; i++) {
			if(input.charAt(i)!=input.charAt(input.length()-1-i)) {
				isPal=false;
				break;
			}
		}

			return isPal;
	}

}
