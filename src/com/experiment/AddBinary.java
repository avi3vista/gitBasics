package com.experiment;

public class AddBinary {
	
	public static void main(String[] args) {
		String a = "10101";
		String b = "10101";
		System.out.println(addBinary(a, b));
	}
	
	public static String addBinary(String a, String b) {
        String result = "";
        
        int aLength=a.length()-1;
        int bLength = b.length()-1;
        StringBuffer sb = new StringBuffer("");
        int carry = 0;
        while(aLength>0 || bLength > 0) {
        	int firstNumber = 0;
        	int secondNumber = 0;
        	
        	if(aLength>=0) {
        		firstNumber = a.charAt(aLength)=='0' ? 0 : 1;
        		aLength--;
        	}
        	if(bLength>=0) {
        		secondNumber = b.charAt(bLength)=='0' ? 0 : 1;
        		bLength--;
        	}
        	if (firstNumber+secondNumber+carry<2) {
        		sb.append(firstNumber+secondNumber);
        		carry=0;
        	}
        	
        	if(firstNumber+secondNumber+carry == 2) {
        		carry=1;
        		sb.append(0);
        	}
        	if(firstNumber+secondNumber+carry == 3) {
        		carry=1;
        		sb.append(1);
        	}
        	
        }
        
        if(carry==1) {
        	sb.append(1);
        }
        
        
        
        return sb.reverse().toString();
    }

}
