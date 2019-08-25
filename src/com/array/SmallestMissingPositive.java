package com.array;

public class SmallestMissingPositive {

  public static void main(String[] args) {
    
    int[] A = {1,2,3};
    
    System.out.println(solution(A));

  }
  
  public static int solution(int[] A) {
    boolean[] present = new boolean[A.length];
    for(int i=0; i<A.length; i++) {
        if(A[i]>0 && A[i]<=A.length) {
            present[A[i]-1]=true;
        }
    }
    int i=0;
    for(i=0; i<A.length; i++) {
        if(!present[i]) {
            break;
        }
    }
    return i+1;
}

}
