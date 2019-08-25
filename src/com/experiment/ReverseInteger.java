package com.experiment;

public class ReverseInteger {

	public static void main(String[] args) {
		
		int x = 10;
		System.out.println(reverse(x));

	}
	
public static int reverse(int x) {
       int result = 0;
       int multiplier = 1;
       
       if (x<0) {
    	   x=-x;
    	   multiplier = -1;
       }
       while(x>=10) {
    	   result = (result *10) + (x%10);
    	   x=x/10;
       }
       result = (result *10) + x;
       
       return result * multiplier;
    }
}


