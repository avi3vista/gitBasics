package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringFromWildCard {

  public static void main(String[] args) {
    
    String s = "1?0?";
    
    String[] res = find_all_possibilities(s);
    
    for(String temp : res) {
      System.out.print(temp + "   ");
    }

  }
  
  static String[] find_all_possibilities(String s) {
    List<String> res = new ArrayList<String>();
    
    find_all_possibilities(s.toCharArray(), 0, res);
    
    return res.toArray(new String[0]);

}

  private static void find_all_possibilities(char[] charArray, int i, List<String> res) {
    if(i>=charArray.length) {
      res.add(String.valueOf(charArray));
      return;
    }
    if(charArray[i]=='?') {
      charArray[i]='0';
      find_all_possibilities(charArray, i+1, res);
      charArray[i]='1';
      find_all_possibilities(charArray, i+1, res);
      charArray[i]='?';
    }
    else {
      find_all_possibilities(charArray, i+1, res);
    }
    
  }

}
