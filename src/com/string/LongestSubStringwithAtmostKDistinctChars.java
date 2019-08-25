package com.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringwithAtmostKDistinctChars {

	public static void main(String[] args) {
		String givenString = "a";
		
		int k = 2;
		
		System.out.println(lengthOfLongestSubstringTwoDistinct(givenString));

	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int k = 2;
        String res="";
	        Map<Character,Integer> count = new HashMap<Character, Integer>();
	        
	        int lt=0, rt=0, max=0, si=0;
	        
	        while(rt<s.length()) {
	        	count.put(s.charAt(rt), count.getOrDefault(s.charAt(rt), 0)+1);
	        
	        
	        if(count.size()==k && rt-lt+1 >max) {
	        	max=rt-lt+1;
	        	si=lt;
	        }
	        rt++;
	        
	        while(count.size()>k) {
	        	if(count.get(s.charAt(lt))==1) {
	        		count.remove(s.charAt(lt));
	        	}
	        	else {
	        		count.put(s.charAt(lt), count.get(s.charAt(lt))-1);
	        	}
	        	lt++;
	        }
	        }
	        
	        
	        return max;
    }
	
	
	 public static String lengthOfLongestSubstringTwoDistinct(String s, int k) {
	        String res="";
	        Map<Character,Integer> count = new HashMap<Character, Integer>();
	        
	        int lt=0, rt=0, max=-1, si=0;
	        
	        while(rt<s.length()) {
	        	count.put(s.charAt(rt), count.getOrDefault(s.charAt(rt), 0)+1);
	        
	        
	        if(count.size()<=k && rt-lt >max) {
	        	max=rt-lt;
	        	si=lt;
	        }
	        rt++;
	        
	        while(count.size()>k) {
	        	if(count.get(s.charAt(lt))==1) {
	        		count.remove(s.charAt(lt));
	        	}
	        	else {
	        		count.put(s.charAt(lt), count.get(s.charAt(lt))-1);
	        	}
	        	lt++;
	        }
	        }
	        
	        if(max!=-1) {
	        	res = s.substring(si, si+max+1);
	        }
	        return res;
	    }

}
