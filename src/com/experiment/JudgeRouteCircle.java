package com.experiment;

public class JudgeRouteCircle {

	public static void main(String[] args) {

		String inputString = "LLRRDDU";
		
		System.out.println(judgeCircle(inputString));
		
	}
	public static boolean judgeCircle(String moves) {
        
		String tempString = moves;
		
		return ((tempString.length()-tempString.replace("L", "").length()==tempString.length()-tempString.replace("R", "").length()) &&
				(tempString.length()-tempString.replace("U", "").length()==tempString.length()-tempString.replace("D", "").length()));
		
		
		
    }

}
