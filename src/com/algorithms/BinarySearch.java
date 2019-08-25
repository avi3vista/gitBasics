package com.algorithms;

import java.net.ServerSocket;

public class BinarySearch {

	
	public static void main(String[] args) {
int[] inputArray = {10,20,30,40,50,60,70,80};
		
		int position = binarySearch2(inputArray, 0, inputArray.length-1, 50);
		System.out.println("the position of the inputString is " + position);
		
	}

	private static int binarySearch(int[] inputArray, int leftIndex, int rightIndex, int searchNumber) {
		
		if(rightIndex>=1) {
			int mid = leftIndex+(rightIndex-1)/2;
			
			if(inputArray[mid]==searchNumber) {
				return mid;
			}
			else if (inputArray[mid] > searchNumber) {
				return binarySearch (inputArray, leftIndex, mid-1, searchNumber);
			}
			else {
				return binarySearch (inputArray, mid+1, rightIndex, searchNumber);
			}
			
		}
		
		
		return -1;
	}
	
	private static int binarySearch2(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
}
