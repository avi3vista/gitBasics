package com.experiment;

public class SortArrayByParity {

	public static void main(String[] args) {
		
		int[] input = {1,1,1,1,2};
		sortArrayByParity(input);
		
		for(int j : input) {
			System.out.print(j + "   ");
		}
		

	}
	
public static int[] sortArrayByParity(int[] A) {
        
	int pointer=0;
	
	for(int i=0; i<A.length; i++) {
		int temp=0;
		if(A[i]%2==0) {
			temp=A[pointer];
			A[pointer++]=A[i];
			A[i]=temp;
		}
	}
	
	return A;
    }

}
