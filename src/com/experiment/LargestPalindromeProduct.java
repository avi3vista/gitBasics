package com.experiment;

import java.math.BigInteger;

public class LargestPalindromeProduct {

	public static void main(String[] args) {

		int n = 8;
		long startTime = System.currentTimeMillis();
		//int result = findLargestPalindromeProduct(n);
		int result = largestPalindrome(n);
		long endTime = System.currentTimeMillis();

		System.out.println(result);
		
		System.out.println("Time taken is " + (endTime-startTime));
		// System.out.println(isPalindrome(906609));
	}

	private static int findLargestPalindromeProduct(int n) {
		int maxNumber = (int) (Math.pow(10, n)) - 1;
		int lowerLimit = (int) (Math.pow(10, n - 1));
		long maxResult = 0;
		long mul = 0;
		long max = 0;
		int outerWindowEnd = maxNumber-5;
		int innerWindowEnd = maxNumber-5;
		int outerWindowStart = maxNumber;
		int innerWindowStart = maxNumber;
		
		do {
		for (int i = outerWindowStart; i > outerWindowEnd; i--) {
			
			max = (long) i * maxNumber;
			if (max < maxResult) {
				break;
			}
			for (int j = maxNumber; j > outerWindowEnd; j--) {
				
				//System.out.println("Two numbers are " + i +"  " + j);
				
				mul = (long) i * j;
				if (mul < maxResult) {
					break;
				}
				if (isPalindrome(mul)) {
					//System.out.println("Found Two numbers are " + i +"  " + j);
					maxResult = mul;
					break;
				}
			}
		}
		
		//System.out.println(outerWindowStart + "  " + outerWindowEnd + "  " + innerWindowStart + "  " + innerWindowEnd);
		outerWindowStart= outerWindowStart-5;
		outerWindowEnd= outerWindowEnd-5;
		innerWindowStart= innerWindowStart-5;
		innerWindowEnd= innerWindowEnd-5;
		}
		
		
		while(outerWindowEnd>lowerLimit);
		
		return (int) (maxResult % 1337);
	}
	
	
	public static int largestPalindrome(int n) {
        // if input is 1 then max is 9 
        if(n == 1){
            return 9;
        }
        
        // if n = 3 then upperBound = 999 and lowerBound = 99
        int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10;
        long maxNumber = (long) upperBound * (long) upperBound;
        
        // represents the first half of the maximum assumed palindrom.
        // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
        int firstHalf = (int)(maxNumber / (long) Math.pow(10, n));
        
        boolean palindromFound = false;
        long palindrom = 0;
        
        while (!palindromFound) {
            // creates maximum assumed palindrom
            // e.g. if n = 3 first time the maximum assumed palindrom will be 998 899
            palindrom = createPalindrom(firstHalf);
            
            // here i and palindrom/i forms the two factor of assumed palindrom
            for (long i = upperBound; upperBound > lowerBound; i--) {
                // if n= 3 none of the factor of palindrom  can be more than 999 or less than square root of assumed palindrom 
                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }
                
                // if two factors found, where both of them are n-digits,
                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }

        return (int) (palindrom % 1337);
    }

    private static long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }
	
	private static boolean isPalindrome(long input) {
		String inputString = String.valueOf(input);
		for (int i = 0; i < inputString.length() / 2; i++) {
			if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
				return false;
			}
		}
		System.out.println("Found " + inputString);
		return true;
	}
}
