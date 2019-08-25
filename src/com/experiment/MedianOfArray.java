package com.experiment;

import java.util.Arrays;

public class MedianOfArray {

	public static void main(String[] args) {
		
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {5,6,7,8,9};
		
		System.out.println("result is " + findMedianSortedArrays(nums1, nums2));

	}
	
public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        
        int[] resultArray = new int[nums1.length+nums2.length];
        for(int i=0; i<nums1.length;i++) {
        	resultArray[i] = nums1[i];
        }
        for(int i=0; i<nums2.length;i++) {
        	resultArray[i+nums1.length] = nums2[i];
        }
        Arrays.sort(resultArray);
        for (int i=0; i<resultArray.length; i++) {
        	System.out.print(" "+resultArray[i]);
        }
        System.out.println();
        if(resultArray.length%2==0) {
        	result = (resultArray[resultArray.length/2]+resultArray[(resultArray.length/2)-1])/2.0;
        	System.out.println(result);
        }
        else {
        	result= resultArray[resultArray.length/2];
        }
        
        return result;
    }

}
