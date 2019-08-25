package com.experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogFileFilter {

	
	public static void main(String[] args) throws FileNotFoundException {
		long StartTime = System.currentTimeMillis();
		String conditionLine="user=admin@testlg.com,        reqsize=645";
		HashMap<String, String> matchingCondition = (HashMap<String, String>) convertToMap(conditionLine.replaceAll("\\s",""));
		Scanner fileScanner = new Scanner (new File("C:\\Users\\Avinash\\Desktop\\ZscalerLog.txt"));
		
		do{
			String currentInputLine = fileScanner.nextLine();
			Map<String, String> inputMap = convertToMap(currentInputLine.replaceAll("\\s",""));
			if(compareInputWithCondition(inputMap, matchingCondition)) {
				System.out.println(currentInputLine);
			}
		}
		while (fileScanner.hasNext());
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken " + (endTime-StartTime));
		
	}

	private static Boolean compareInputWithCondition(Map<String, String> inputMap, Map<String, String> matchingConditions) {
		Boolean matched=true;
	    for (Object key : matchingConditions.keySet()) {
	    	if(inputMap.containsKey(key)) {
	    		if(!(matchingConditions.get(key).equals(inputMap.get(key)))) {
	    			matched=false;
	    			break;
	    		}
	    	}
	    		else
	    		{
	    			matched=false;
	    			break;
	    		}
	    	}
	    return matched;
	    		
	    }

	private static Map<String, String> convertToMap(String inputLine) {
		String[] tokens = inputLine.split(",");
	    Map<String, String> map = new HashMap<>();
	    for (int i=0; i<tokens.length; i++) 
	    	{
	    	String[] strings = tokens[i].split("=");
	        if(strings.length==2)
	         map.put(strings[0], strings[1].replaceAll("%2C", ","));
	    	}
		return map;
	}
	    
	}
