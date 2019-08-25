package com.experiment;

import java.util.ArrayList;

public class GeneratePrimeMultiples {
	
	public static void main(String[] args) {
		ArrayList primeMultiples = returnPrimeMultiples(171234);
		
		System.out.println(primeMultiples.toString());
		
	}
	
	public static ArrayList returnPrimeMultiples (int target) {
		
		ArrayList primeMultiples = new ArrayList<>();
		int reminder = target;
		for (int i=2; i<=target; i++)
		{
			if (reminder%i==0) {
				primeMultiples.add(i);
				reminder=reminder/i;
				i--;
			}
			if(reminder==1) {
				break;
			}
		}
		
		return primeMultiples;
		
	}

}
