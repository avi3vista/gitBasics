package com.algorithms;

public class FibonacciNumber {


	public static void main(String[] args) {
		int inputNumber = 15;
		for (int i=0; i<=inputNumber; i++) {
			System.out.println("Fibonacci Number for "+ i + " is "+ findFibonacciNumber(i));
		}
		
	}

	private static int findFibonacciNumber(int inputNumber) {
		
		//System.out.println(inputNumber);
		if(inputNumber==0) {
			return 0;
		}
		else if (inputNumber==1) {
			return 1;
		}
		else {
			return findFibonacciNumber(inputNumber-1) + findFibonacciNumber(inputNumber-2);
		}
		
		
	}

}
