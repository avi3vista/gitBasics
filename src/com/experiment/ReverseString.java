package com.experiment;

public class ReverseString {


public static void main(String[] args) {
	String s = null;
	System.out.println("Reversed String is " + reverseString(s));
}

public static String reverseString(String s) {
	if(s!=null && !s.equalsIgnoreCase("")){
		StringBuffer outputString = new StringBuffer();
	    
	    for(int i=s.length()-1;i>=0;i--) {
	    	outputString.append(s.charAt(i));
	    }
	    
	    return outputString.toString();
	}
	else {
		return s;
	}
    
}

}
