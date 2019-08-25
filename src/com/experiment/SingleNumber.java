package com.experiment;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {
		int[] input = {4,1,2,1,2,4};
		System.out.println(singleNumber(input));

	}
	
	public static int singleNumber(int[] nums) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int currentNumber : nums) {
			if(map.containsKey(currentNumber)) {
				map.remove(currentNumber);
			}
			else {
				map.put(currentNumber, currentNumber);
			}
		}
		
		return map.get(map.keySet().iterator().next());
	}

}
