package com.array;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    
    int[] nums = {1,2,3,4};
    int[] res = getProductArray(nums);
    for(int t : res)
    System.out.print(t + "  ");

  }
  
  static int[] getProductArray(int[] nums) {
   
    int[] res = new int[nums.length];
    res[0]=1;
    for(int i=1; i<nums.length; i++) {
      res[i]= res[i-1]*nums[i-1];
    }
    
    int temp =1;
    
    for(int i=nums.length-2; i>=0; i--) {
      temp*=nums[i+1];
      res[i]=res[i]*temp;
    }
    
    return res;
}

}
