package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary02 {

  public static void main(String[] args) {

    String[] words = {"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"};

    System.out.println(find_order(words));

  }

  static String find_order(String[] words) {
    StringBuffer[] res = new StringBuffer[1];
    res[0] = new StringBuffer("");

    if (words.length == 0) {
      return null;
    }
    Set<Character> visited = new HashSet<Character>();
    if (words.length == 1) {
      for (char c : words[0].toCharArray()) {
        if (!visited.contains(c)) {
          res[0].append(c);
          visited.add(c);
        }
      }
      return res[0].toString();
    }
    Map<Character, List<Character>> ref = new HashMap<Character, List<Character>>();
    for (int i = 0; i < words.length - 1; i++) {
      int in1 = 0;
      int in2 = 0;
      boolean found = false;
      char[] c1 = words[i].toCharArray();
      char[] c2 = words[i + 1].toCharArray();
      while (in1 < c1.length && in2 < c2.length) {
        if (ref.get(c1[in1]) == null) {
          ref.put(c1[in1], new ArrayList<Character>());
        }
        if (ref.get(c2[in2]) == null) {
          ref.put(c2[in2], new ArrayList<Character>());
        }
        if (c1[in1] != c2[in2]) {
          found = true;
          break;
        }
        in1++;
        in2++;
      }
      if (found) {
        if(ref.get(c1[in1]).contains(c2[in2])) {
          return "";
        }
        ref.get(c2[in2]).add(c1[in1]);
      }
      while(in2<c2.length) {
        if(ref.get(c2[in2])==null) {
          ref.put(c2[in2], new ArrayList<Character>());
        }
            in2++;
        }
      
      while(in1<c1.length) {
        if(ref.get(c1[in1])==null) {
          ref.put(c1[in1], new ArrayList<Character>());
        }
            in1++;
        }
    }

    dfs(ref, res, visited);

    return res[0].toString();

  }

  private static void dfs(Map<Character, List<Character>> ref, StringBuffer[] res,
      Set<Character> visited) {
    for (Character c : ref.keySet()) {
      dfs(ref, res, c, visited);
    }

  }

  private static void dfs(Map<Character, List<Character>> ref, StringBuffer[] res, Character c,
      Set<Character> visited) {

    if (visited.contains(c)) {
      return;
    }

    visited.add(c);


    for (Character tempC : ref.getOrDefault(c, new ArrayList<Character>())) {
      dfs(ref, res, tempC, visited);
    }
    res[0].append(c);



  }

}
