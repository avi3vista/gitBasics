package com.recursion;

public class InterleavingStringsRecurssion {

  
  public static void main(String[] args) {
    String a="aabcc";
    String b = "dbbca";
    String i = "aadbbcbcac";
    
    System.out.println(doStringsInterleave(a,b,i));
  }

  private static boolean doStringsInterleave(String a, String b, String i) {
    if(i.length()!=a.length()+b.length()) {
      return false;
    }
    
    return doStringsInterleave(a, b, i,0,0,0);
    
  }

  private static boolean doStringsInterleave(String a, String b, String i, int i1, int i2, int i3) {
    if(i3>=i.length() && i1>=a.length() && i2>=b.length()) {
      return true;
    }
    if(i1<a.length() && i2<b.length() && i3<i.length()) {
      return (a.charAt(i1)==i.charAt(i3) && doStringsInterleave(a, b, i, i1+1, i2, i3+1)) || (b.charAt(i2)==i.charAt(i3) && doStringsInterleave(a, b, i, i1, i2+1, i3+1));
    }

    
    return false;
    
  }
}
