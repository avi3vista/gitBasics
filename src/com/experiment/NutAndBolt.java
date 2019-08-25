package com.experiment;

import java.util.HashMap;
import java.util.Map;

public class NutAndBolt {

	public static void main(String[] args) {
		
		int[] nuts = {4, 32, 5, 7};

		int[] bolts = {32, 7, 5, 4};
		
		String[] result = solve(nuts, bolts);
		
		for(String s : result) {
		System.out.println(s);
		}

	}
	
	static String[] solve(int[] nuts, int[] bolts) {
		
		String[] result = new String[nuts.length];
		Map<Integer,Integer> mapping = new HashMap<Integer, Integer>();
		for(int i=0; i<bolts.length; i++) {
			mapping.put(bolts[i], i);
		}
		
		for(int i=0; i<nuts.length; i++) {
			result[i] = String.valueOf(nuts[i]) + " " + String.valueOf(bolts[mapping.get(nuts[i])]);
		}
		
		return result;

    }

}
