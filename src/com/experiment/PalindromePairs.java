package com.experiment;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {

	public static void main(String[] args) {
		
		String[] words = {"bat", "tab", "cat"};
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i=0; i<words.length-1; i++) {
			for(int j=i+1; j<words.length; j++) {
				
				if(words[j].contains(words[i]))
				
				if(isPalindrome(words[i]+words[j])){
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.add(i);
					tempList.add(j);
					result.add(tempList);
				}
				if(isPalindrome(words[j]+words[i])){
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.add(j);
					tempList.add(i);
					result.add(tempList);
				}
			}
		}

	}
	
	
	public static boolean isPalindrome(String input) {
		boolean result = true;
		
		int low=0;
		int high = input.length()-1;
		
		while(low<high) {
			if(input.charAt(low)!=input.charAt(high)) {
				result = false;
				break;
			}
			low++;
			high--;
		}
		
		return result;
	}

}
