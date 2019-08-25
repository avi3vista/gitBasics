package com.experiment;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"abcd", "abcde", "abc", "abcdef"};
		System.out.println("common prefix is "+longestCommonPrefix(strs));

	}
	

	public static String longestCommonPrefix(String[] strs) {
        Integer smallestLength = null;
        Integer smallestLengthIndex = null;
        StringBuffer commonPrefix = new StringBuffer();
        String currentString = null;
        for(int i=0; i<strs.length; i++) {
        	currentString = strs[i];
        	if(smallestLength==null || smallestLength > currentString.length()) {
        		smallestLength = currentString.length();
        		smallestLengthIndex = i;
        	}
        }
        if(smallestLength==null || smallestLength==0) {
        	return commonPrefix.toString();
        }
        boolean breakPoint = false;
        for(int i=0; i<smallestLength; i++) {
        	Character currentCharacter = strs[smallestLengthIndex].charAt(i);
        	for(int j=0; j<strs.length; j++) {
        		if(currentCharacter != strs[j].charAt(i)){
        			breakPoint=true;
        			break;
        		}
        		
        	}
        	
        	if(breakPoint) {
        		break;
        	}
        	else {
        		commonPrefix.append(currentCharacter);
        	}
        }
        
        
        return commonPrefix.toString();
    }

}
