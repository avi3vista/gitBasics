package com.experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogFileFilterWithoutMap {

	
	public static void main(String[] args) throws FileNotFoundException {
		long startTime= System.currentTimeMillis();
		String conditionLine="user=admin@testlg.com,        reqsize=645";
		conditionLine = conditionLine.replaceAll("\\s","");
		String conditions[] = conditionLine.trim().split(",");
		Scanner fileScanner = new Scanner (new File("C:\\Users\\Avinash\\Desktop\\ZscalerLog.txt"));
		
		do{
			String currentInputLine = fileScanner.nextLine();
			currentInputLine = currentInputLine.replaceAll("\\s","");
			String currentLineString[]= currentInputLine.trim().split(",");
			Boolean matched = true;
			for(String conditionString : conditions) {
				
				if(!(Arrays.asList(currentLineString).contains(conditionString)))
				{
				matched=false;
				break;
				}
			}
			if(matched) {
				System.out.println(currentInputLine);
			}
		}
		while (fileScanner.hasNext());
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken " + (endTime-startTime));
	}
	
	
		}
