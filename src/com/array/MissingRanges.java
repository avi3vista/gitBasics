package com.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

  public static void main(String[] args) {
   int[] nums = {2147483647};
   int lower = -2147483648;
   int upper = 2147483647;
   
   List<String> res = findMissingRanges(nums, lower, upper);
   
   for(String s : res) {
     System.out.println(s);
   }
   
  }
  
  public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    
    List<String> res = new ArrayList<String>();
    
    if(nums==null || nums.length==0) {
      if(upper!=lower){
        res.add(lower + "->" + upper);
      }
      if(upper==lower) {
        res.add(String.valueOf(upper));
      }
      return res;
    }
    
    if(nums[0]-lower==1) {
      res.add(String.valueOf(lower));
    }
    if(nums[0]-lower >1 || nums[0]-lower<0) {
      res.add(lower + "->" + String.valueOf(nums[0]-1));
    }
    
    for(int i=0; i<nums.length-1; i++) {
      if(nums[i+1]-nums[i]==2) {
        res.add(String.valueOf(nums[i]+1));
      }
      if(nums[i+1]-nums[i]>2 || nums[i+1]-nums[i]<0) {
        res.add(String.valueOf(nums[i]+1) + "->" + String.valueOf(nums[i+1]-1));
      }
    }
    
    if(upper-nums[nums.length-1]==1) {
      res.add(String.valueOf(upper));
    }
    if(upper-nums[nums.length-1] >1 || upper-nums[nums.length-1]<0) {
      res.add(String.valueOf(nums[nums.length-1]+1) + "->" + String.valueOf(upper));
    }
    
    
    return res;
  }

}
