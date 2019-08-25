package com.string;

public class RepeatedStringMatch {

  public static void main(String[] args) {
    String A = "aaac";
    String B = "aac";
    System.out.println(repeatedStringMatch(A, B));
  }
  
  public static int repeatedStringMatch(String A, String B) {
    int count = 0;
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();
    int bIdx = 0;
    while ( bIdx<a.length && b[0]!=a[bIdx] ) {
      bIdx++;
    }
    if(bIdx==b.length) {
      return -1;
    }
    
    for(int i=0; i<b.length; i++) {
      if(b[i]!=a[(i+bIdx)%a.length]) {
        return -1;
      }
      if ((i+bIdx)%a.length==0 && i!=0) {
        count++;
      }
    }
    
    
    return count+1;
  }

}
