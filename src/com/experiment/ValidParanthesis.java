package com.experiment;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {

		
		Map paranthesis = new HashMap();
		paranthesis.put("(", ")");
		paranthesis.put("[", "]");
		paranthesis.put("{", "}");
		
		System.out.println(checkValidity(paranthesis, "]]]"));
		
		
	}

	public static Boolean checkValidity (Map paranthesis, String s) {
		
		Boolean isValid = true;
		Stack charStack = new Stack();

		for(int i=0; i<s.length(); i++) {
			
			if(paranthesis.containsKey(String.valueOf(s.charAt(i)))) {
				charStack.push(String.valueOf(s.charAt(i)));
			}
			else if (charStack.isEmpty() || !(String.valueOf(s.charAt(i)).equals(paranthesis.get(charStack.pop())))) {
				isValid = false; 
				break;
			}
			
			
		}
		if(!charStack.isEmpty()) {
			isValid=false;
		}
		
		
		
		return isValid;
	}
}
