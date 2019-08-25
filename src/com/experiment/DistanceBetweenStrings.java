package com.experiment;

public class DistanceBetweenStrings {

	public static void main(String[] args) {

		String firstString = "1234";
		StringBuffer stringBuffer = new StringBuffer("");
		char[] charArray = firstString.toCharArray();
		int firstInt = Integer.parseInt(String.valueOf(charArray[0]));
		
		stringBuffer= stringBuffer.append(firstString);
		
		System.out.println("stringBuffer + " +  firstInt);
	}
	

}
