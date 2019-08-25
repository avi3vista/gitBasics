package com.experiment;

public class CircularArrayLoop {

	public static void main(String[] args) {

		int[] inputArray = {2, -1, 1, 2, 2};
		System.out.println("isCircular = " + circularArrayLoop(inputArray));
	}
	
public static boolean circularArrayLoop(int[] nums) {
        boolean circular = false;
        int iteratorIndex = 0; int hops = 0;
        for(int i=0; i<nums.length && !circular; i++) {
        	hops = 0;
        	iteratorIndex=i;
        	for(int j=i;j<nums.length;) {
        	iteratorIndex=iteratorIndex+nums[j];
        	System.out.println("i = " + i + " iterator index = " + iteratorIndex + " hops = " + hops);
        	if(iteratorIndex>=nums.length) {
        		iteratorIndex = iteratorIndex%nums.length;
        	}
        	if(iteratorIndex<0) {
        		iteratorIndex = nums.length - (iteratorIndex%nums.length);
        	}
        	if(iteratorIndex==j) {
        		if(hops==0) {
        			circular = false;
        		}
        		else {
        		circular=true;
        		}
        		break;
        	} 
        	j=iteratorIndex;
        	hops++;
        	}
        }
        
        return circular;
    }

}
