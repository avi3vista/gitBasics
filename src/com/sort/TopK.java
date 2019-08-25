package com.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopK {

	public static void main(String[] args) {
		
		int[] nums = {1,1,1,2,2,2,3,3,3,3};
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		
		System.out.println(topKFrequent(words, 4));

	}
	
	static int[] topK(int[] arr, int k) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i: arr) {
			ts.add(i);
		}
		List<Integer> res = new ArrayList<Integer>();
		while(!ts.isEmpty() && res.size()<=k) {
			res.add(ts.pollFirst());
		}
		int[] ret = new int[res.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = res.get(i);
		  return ret;
		

    }
	
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<String>();
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for(String s : words) {
			countMap.put(s, countMap.getOrDefault(s, 0)+1);
		}
		
		TreeMap<Integer, TreeSet<String>> tm = new TreeMap<Integer, TreeSet<String>>();
		
		for(String s : countMap.keySet()) {
			if(!tm.containsKey(countMap.get(s))) {
				tm.put(countMap.get(s), new TreeSet<String>());
			}
			tm.get(countMap.get(s)).add(s);
			
		}
		
		while(res.size()<k && !tm.isEmpty()) {
			TreeSet<String> ll = tm.get(tm.lastKey());
			while(res.size()<k && !ll.isEmpty()) {
				res.add(ll.pollFirst());
			}
			if(ll.isEmpty()) {
				tm.remove(tm.lastKey());
			}
		}
		
		return res;
        
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> arrMap = new HashMap<Integer,Integer>();
        for(int i: nums) {
        	arrMap.put(i, arrMap.getOrDefault(i,0)+1);
        }
        TreeMap<Integer, LinkedList<Integer>> tm = new TreeMap<Integer, LinkedList<Integer>>();
        
        for(Integer i : arrMap.keySet()) {
        	if(!tm.containsKey(arrMap.get(i))) {
        		tm.put(arrMap.get(i), new LinkedList<Integer>());
        	}
        	tm.get(arrMap.get(i)).add(i);
        }
        while(res.size()<k && !tm.isEmpty()) {
        	int lk = tm.lastKey();
        	LinkedList<Integer> intList = tm.get(lk);
        	while(res.size()<k && !intList.isEmpty()) {
        		res.add(intList.poll());
        	}
        	if(intList.isEmpty()) {
        		tm.remove(lk);
        	}
        }
        return res;
    }

}
