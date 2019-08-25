package com.experiment;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {

	public static void main(String[] args) {
		Comparator<Map.Entry<Integer, Integer>> cc = new Comparator<Map.Entry<Integer, Integer>>() {
			
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			};
		};
		Map<Integer, Integer> test = new HashMap<Integer, Integer>();
		
		
		test.put(5, test.getOrDefault(5, 0)+1);
		test.put(1, test.getOrDefault(1, 0)+1);
		test.put(1, test.getOrDefault(1, 0)+1);
		test.put(2, test.getOrDefault(2, 0)+1);
		test.put(3, test.getOrDefault(3, 0)+1);
		
		test.put(2, test.getOrDefault(2, 0)+1);
		test.put(4, test.getOrDefault(4, 0)+1);
		test.put(50, test.getOrDefault(50, 0)+1);
		test.put(5, test.getOrDefault(5, 0)+1);
		
		Set<Map.Entry<Integer, Integer>> ss = new TreeSet<Map.Entry<Integer, Integer>>(cc);
		ss.addAll(test.entrySet());
		
		for(int t : test.keySet()) {
			System.out.println("key is " + t + " value is " + test.get(t));
		}
		System.out.println("================================================");
		for(Map.Entry<Integer, Integer> t : ss) {
			System.out.println("key is " + t.getKey() + " value is " + t.getValue());
		}

	}

}
