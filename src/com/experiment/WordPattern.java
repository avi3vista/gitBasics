package com.experiment;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class WordPattern {

	public static void main(String[] args) {
		
		String pattern = "abba";
		String str = "dog cat cat dog";
		
		System.out.println(wordPattern(pattern, str));

	}
	
	public static boolean wordPattern(String pattern, String str) {
        boolean matches = true;
        
        Map<String, Character> strToPattern = new HashMap<>();
        Map<Character, String> patternToStr = new HashMap<>();
        
        String[] strArray = str.split(" ");
        if(strArray.length != pattern.length()) {
        	return false;
        }
        for(int i=0; i<strArray.length; i++) {
        	if(strToPattern.containsKey(strArray[i]) || patternToStr.containsKey(pattern.charAt(i))) {
        		if( !(strToPattern.containsKey(strArray[i]) && patternToStr.containsKey(pattern.charAt(i))) ||
        				strToPattern.get(strArray[i])!= pattern.charAt(i) || strArray[i]== patternToStr.get(pattern.charAt(i))) {
        			matches = false;
        			break;
        		}
        	}
        	else {
        		strToPattern.put(strArray[i], pattern.charAt(i));
        		patternToStr.put(pattern.charAt(i),strArray[i]);
        	}
        }
        return matches;
    }

}
