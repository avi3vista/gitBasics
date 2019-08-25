package com.experiment;

public class NonDecreasingArray {
	
	
	public static void main(String[] args) {
		int[] inputArray = {1,2,5,3,3};
		
		System.out.println(checkPossibility(inputArray));
	}
	
    public static boolean checkPossibility(int[] nums) {
    	int maxUpdate=0;
    	if(nums.length<=1) {
    		return true;
    	}
    	if(nums[0]>nums[1]) {
    		nums[0]=nums[1]-1;
    		maxUpdate=1;
    	}
    	else {
    		nums[1]=nums[0]+1;
    	}
    	for(int i=1;i<nums.length-1;i++) {
    		System.out.println("" + nums[i] + "  " + nums[i+1]);
    		if(nums[i-1]>nums[i]){
    			if(maxUpdate==1) {
    				return false;
    			}
    			else {
    				maxUpdate=1;
    				nums[i]=Integer.min(nums[i-1]+1, nums[i+1]-1);
    			}
    		}
    		if(nums[i]>nums[i+1]){
    			if(maxUpdate==1) {
    				return false;
    			}
    			else {
    				maxUpdate=1;
    				nums[i]=nums[i-1]+1;
    			}
    		}
			nums[i]=Integer.min(nums[i-1]+1, nums[i+1]-1);
    	}
    	if(nums[nums.length-1]<=nums[nums.length-2] && maxUpdate>=1) {
    		return false;
    	}
    	return true;
        
    }

}
