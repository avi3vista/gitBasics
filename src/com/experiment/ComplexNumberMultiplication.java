package com.experiment;

public class ComplexNumberMultiplication {

	public static void main(String[] args) {
		String a = "10+20i";
		String b = "11+2i";
		
		System.out.println(complexNumberMultiply(a, b));
		
		
	}
	
public static String complexNumberMultiply(String a, String b) {
        String result = null;
        
        
        String[] aList = a.split("\\+");
        String[] bList = b.split("\\+");
        
        int p = Integer.valueOf(aList[0]);
        int q = Integer.valueOf(aList[1].split("i")[0]);
        
        int r = Integer.valueOf(bList[0]);
        int s = Integer.valueOf(bList[1].split("i")[0]);
        

        result = String.valueOf(p*r+(q*s*(-1))) + "+" + String.valueOf(q*r+p*s) + "i"; 
        
	return result;
    }
}
