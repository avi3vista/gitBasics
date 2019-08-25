package com.experiment;

public class GeneratePrimeNumbers {
	
	
	public static void main(String[] args) {
		
		int upperLimit = 100;
		Boolean isPrime = true;
		for (int i=0; i<upperLimit; i++)
		{
			isPrime=true;
			for (int j=2; j<i ; j++) {
				if (i%j == 0) {
					isPrime=false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(i);
			}
				
		}
		
		
	}

}
