package com.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = {10,3,-4,1,-6,9};
		
		String[] res = findZeroSum(arr);
		
		for(String s: res)
		System.out.println(s);

	}

	private static String[] findZeroSum(int[] arr) {
		
		Arrays.sort(arr);
		
		return findZeroSumSort(arr);
	}

	private static String[] findZeroSumSort(int[] arr) {
		Set<String> res = new HashSet<String>();
		for(int i=0; i<arr.length-2; i++) {
			int lp = i+1;
			int rp=arr.length-1;
			while(lp<rp) {
				if(arr[i]+arr[lp]+arr[rp] > 0) {
					rp--;
				}
				else if (arr[i]+arr[lp]+arr[rp] < 0) {
					lp++;
				}
				else {
					res.add(i+","+lp+","+rp);
					lp++;
					
				}
			}
		}
		return res.toArray(new String[0]);
		
	}

}
