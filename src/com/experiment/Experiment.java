package com.experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Experiment {
  static Semaphore semaphore = new Semaphore(4);

	public static void main(String[] args) {
		
				sim[] simArray = new sim[10];
				Object[] obj = new Object[2];
				
				obj[0] = "testString";
				obj[1] = new sim(10,1);

        for(Object o : obj ) {
          System.out.println(o);
        }
	}
	
public int strangePrinter(String s) {
        Set<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()) {
        	set.add(c);
        }
        return set.size();
    }
	
	public static int findValue(int i, int j, int n) {
		int result = 0;
		if(n==0){
	return i;
	}
	if (n==1) {
	return j;
	}	
		result = findValue(i,j, n-2) + findValue(i,j, n-1)*findValue(i,j, n-1);
		return result;
	}
	
	public static double findValue1(int i, int j, int n) {
		
		double[] results = new double[n];
		results[0] = i;
		results[1] = j;

		for(int k=2; k<n;k++) {
		results[k] = results[k-1] + results[k-2] * results[k-2];
		}		
			
			return results[n-1];
		}

	


	private static int doStuff(String s) {

		return Integer.parseInt(s);

	}

	public static Map<Integer, Integer> sortByValues(final Map<Integer, Integer> map) {
		Comparator<Integer> valueComparator = new Comparator<Integer>() {
			public int compare(Integer k1, Integer k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<Integer, Integer> sortedByValues = new TreeMap<Integer, Integer>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int max = 0;

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum == k) {
				max = Math.max(max, i + 1);
			}

			int diff = sum - k;

			if (map.containsKey(diff)) {
				max = Math.max(max, i - map.get(diff));
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}

		return max;
	}
	
	static class sim {
	  int one;
	  int two;
    public sim(int one, int two) {
      super();
      this.one = one;
      this.two = two;
    }
    
    public sim() {
      super();
      this.one = 0;
      this.two = 0;
    }
    
   @Override
  public String toString() {
  // TODO Auto-generated method stub
  return "one = " + this.one + "  two = " + this.two;
  } 
    
    
	  
	}

}