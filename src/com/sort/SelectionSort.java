package com.sort;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] firstArray = {110 ,122,344,55,53,64,66,77};
		int temp=0;
		int minNumber;
		int minIdx=0;

		for(int i=0; i<firstArray.length;i++) {
			System.out.print(firstArray[i] + "     ");
		}
		System.out.println("");
		
		for(int i=0; i<firstArray.length;i++) {
			minIdx=i;
			for(int j=i+1; j<firstArray.length; j++) {
				if(firstArray[minIdx]>firstArray[j]) {
					minIdx = j;
				}
				
			}
			temp = firstArray[i];
			firstArray[i]=firstArray[minIdx];
			firstArray[minIdx] = temp;
			
			System.out.println("minIdx = " + minIdx);
			
		}
		for(int idx=0; idx<firstArray.length;idx++) {
			System.out.print(firstArray[idx] + "     ");
		}
		System.out.println("");
		
		
	}

}
