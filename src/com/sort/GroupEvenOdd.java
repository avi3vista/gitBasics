package com.sort;

public class GroupEvenOdd {

	public static void main(String[] args) {
		
		int[] arr = {7};
		for(int i: arr) {
			System.out.print(i + "  ");
		}
		System.out.println();
		groupEvenOdd(arr);

		
		for(int i: arr) {
			System.out.print(i + "  ");
		}
	}

	private static void groupEvenOdd(int[] arr) {
		
		int rt = arr.length-1;
		
		for(int i=0; i<=rt; i++) {
			if(arr[i]%2!=0) {
				while(rt>=0 && arr[rt]%2!=0) {
					rt--;
				}
				if(i<rt) {
				swap(arr, i, rt);
				}
			}
		}
		
	}

	private static void swap(int[] arr, int i, int rt) {
		int temp = arr[i];
		arr[i] = arr[rt];
		arr[rt]=temp;
		
	}

}
