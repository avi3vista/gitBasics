package com.experiment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaxSumOf3NonOverlappingArray {

	public static void main(String[] args) {
		
		
		int[] input = {10,20,11,2,6,7,5,1};
		int k = 2;
		System.out.println(maxSumOfThreeSubarrays(input, k));

	}
	
	 public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		 
		 if (nums.length<=k){
			 return null;
		 }
	        int[] result = new int[3];
	     Map<Integer, Integer> prefixMap = new HashMap<Integer, Integer>();
	        for(int i=0; i<nums.length-k; i++) {
	        	int sum = 0;
	        	int temp = i;
	        	for(int j=0; j<k; j++) {
	        		sum+=nums[temp++];
	        	}
	        	
	        	prefixMap.put(i,sum);
	        }
	        
	        
	        
	        for(int  j: prefixMap.keySet()) {
	        	System.out.println("j = " + j + "  value = " +  prefixMap.get(j));
	        }
	        
	        Set<Map.Entry<Integer,Integer>> sortedSet = new TreeSet<Map.Entry<Integer,Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){

				@Override
				public int compare(Entry<Integer, Integer> v1, Entry<Integer, Integer> v2) {
					if(v1.getValue()==v2.getValue()) {
						 return v2.getKey()-v1.getKey();
					 }
					 else return v2.getValue()-v1.getValue();
				}
	        });
	        
	        sortedSet.addAll(prefixMap.entrySet());
	        
	        for(Entry<Integer, Integer> j : sortedSet) {
	        	System.out.println("sortedSet   " + j.getKey());
	        }
	        
	        
	        List<Integer> resultList = new ArrayList<Integer>();
	        
	        int maxSum = 0;
	        Iterator<Entry<Integer,Integer>> sortedSetIterator = sortedSet.iterator();
	        int prevKey = -100;
	        int count=0;
	        Entry<Integer,Integer> currentEntry = null;
	        while(sortedSetIterator.hasNext()) {
	        	currentEntry = sortedSetIterator.next();
	        	if(Math.abs(prevKey-currentEntry.getKey())>k && count<3) {
	        		prevKey= currentEntry.getKey();
	        		maxSum+=currentEntry.getValue();
	        		count++;
	        		resultList.add(currentEntry.getKey());
	        	}
	        	
	        		
	        		
	        		
	        }
	        
	        System.out.println("sadasdasdasda   " + resultList );
	        
	        return result;
	    }
	 
	 
	 

}
