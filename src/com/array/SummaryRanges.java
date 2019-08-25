package com.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

  public static void main(String[] args) {
    
    int[] nums = {-2147483648,-2147483647,2147483647};
    
    System.out.println(summaryRanges(nums));

  }
  
  public static List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<String>();
    
    for(int i=0; i<nums.length;) {
      StringBuffer temp = new StringBuffer(String.valueOf(nums[i]));
      int j=i;
      while(j<nums.length-1) {
        if(Long.valueOf(nums[j+1])-Long.valueOf(nums[j])>1) {
          break;
        }
        j++;
      }
      if(i!=j) {
        i=j;
        temp.append("->"+String.valueOf(nums[j]));
        
      }
      res.add(temp.toString());
      i++;
      
    }
    
    return res;
    
    
  }

}
