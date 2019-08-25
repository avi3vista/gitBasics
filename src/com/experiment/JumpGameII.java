package com.experiment;

public class JumpGameII {

	public static void main(String[] args) {
		
		
		//int[] nums = {4,7,1,2,1,2,0};
		
				//int[] nums = {3,4,-1,1};
				//int[] nums={1,2,0};
				int[] nums = {2,1};
				
				System.out.println("The result is " + jump(nums));

	}
	
	public static int jump(int[] nums) {
		int result = 0;
		/*if(nums.length<=1) {
			return 1;
		}
		for(int i=0;i<nums.length;result++) {
			if(nums[i]!=0) {
				i+=nums[i];
			}
			else {
				i++;
			}
		}
		
		return result;*/
        
		int i=1;
		while (i<nums.length) {
			result++;
			i+=nums[i-1];
			if(i-1<nums.length && nums[i-1]==0) {
				i++;
			}
		}
		
		return result;
		
		
		
    }

}
