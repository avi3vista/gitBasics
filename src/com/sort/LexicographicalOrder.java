package com.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LexicographicalOrder {

	public static void main(String[] args) {

		
		String[] arr = {"key1 abcd", "key2 zzz", "key1 hello", "key3 world", "key1 hello"};
		String[] res = solve(arr);
		for(String s : res)
		System.out.println(s);
	}
	
	public static String[] solve(String[] arr) {
     List<String> res = new ArrayList<String>();
     
     Map<String,Integer> fre = new HashMap<String, Integer>();
     Map<String,String> ord = new HashMap<String, String>();
     
     for(String s : arr) {
    	 String[] temp = s.split(" ");
    	 String s1 = temp[0];
    	 String s2 = temp[1];
    	 
    	 fre.put(s1, fre.getOrDefault(s1, 0)+1);
    	 
    	 if(ord.containsKey(s1)) {
    		 ord.put(s1, s2.compareTo(ord.get(s1))>0 ? s2 : ord.get(s1));
    	 }
    	 else 
    	 {
    		 ord.put(s1,s2);
    	 }
     }
     for(String s : fre.keySet()) {
    	 res.add(s+":"+fre.get(s)+","+ord.get(s));
     }
     
     
     return res.toArray(new String[0]);
    }
	
public static List<Integer> lexicalOrder(int n) {
	Comparator<Integer> cc = new Comparator<Integer>() {
		@Override
		public int compare(Integer arg0, Integer arg1) {
			//return arg0.toString().compareTo(arg1.toString());
			return String.valueOf(arg0).compareTo(String.valueOf(arg1));
		}
	};
	Set<Integer> res = new TreeSet<Integer>(cc);
	for(int i=1; i<=n ; i++ ) {
		res.add(i);
	}
	return new ArrayList<Integer>(res);
    }

}
