package com.array;

public class LongestTurbulance {

  public static void main(String[] args) {
    

    int[] A = {37,199,60,296,257,248,115,31,273,176};
    
    System.out.println(solution(A));

  }
  
  public static int solution(int[] A) {
    if(A==null || A.length ==0) {
      return 0;
    }
    if(A.length==1) {
      return 1;
    }
    if(A.length==2) {
      if(A[1]!=A[0]) {
        return 2;
      }
      return 1;
    }
    
    int startIndex = 0;
    int maxSofar=1;
    if(A[1]!=A[0]) {
      maxSofar=2;
    }
    for(int i=1; i<A.length-1; i++) {
      if((A[i]>A[i-1] && A[i]>A[i+1]) || (A[i]<A[i-1] && A[i]<A[i+1])) {
        maxSofar = Math.max(maxSofar, i+1-startIndex+1);
      }
      else {
        startIndex=i;
      }
      
    }
    return maxSofar;
    
  }

}
