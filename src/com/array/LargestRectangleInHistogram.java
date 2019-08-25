package com.array;

import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    int[] heights = {1,2,3,4,5};
    System.out.println(largestRectangleArea(heights));

  }
  
  
  public static int largestRectangleArea(int[] heights) {
    int max=0;
    Stack<Integer> maxSoFar = new Stack<>();
    Stack<Integer> index = new Stack<>();
    for(int i=0; i<heights.length; i++) {
      if(!maxSoFar.isEmpty() && maxSoFar.peek() <= heights[i]) {
        max=max+maxSoFar.peek();
        max = Math.max(max, heights[i]);
      }
      else {
        while(!maxSoFar.isEmpty() && maxSoFar.peek()>heights[i]) {
          maxSoFar.pop();
          index.pop();
        }
        
      }
      if(maxSoFar.isEmpty()) {
        max = Math.max(max, heights[i]*(i+1));
        maxSoFar.push(heights[i]);
        index.push(0);
      }
      max = Math.max(max, maxSoFar.peek() * (i+1-index.peek()));

      
      if(maxSoFar.peek()<heights[i]) {
        maxSoFar.push(heights[i]);
        index.push(i);
      }
      
    }
    
    return max;
    
}

}
