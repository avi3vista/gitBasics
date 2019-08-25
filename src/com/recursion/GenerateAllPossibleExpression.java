package com.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GenerateAllPossibleExpression {

	public static void main(String[] args) {
		
		
		long target = 124;
		
		String s = "1123";
		String arr[] = generate_all_expressions(s, target);
		
		for(String st: arr) {
			System.out.println(st);
		}

	}
	
	static String[] generate_all_expressions(String s, long target) {
		Set<String> expressions = new HashSet<String>();
		String currentExpression = s.substring(0, 1);
		int currentVal = Integer.parseInt((s.substring(0,1)));;
		if(s.length()>0) {
			evaluate(s, 1, currentVal, currentExpression, "", target, expressions, 0);
		}
		String arr[] = new String[0]; 
		
		return expressions.toArray(arr);
    }
	

	 private static void evaluate(String nums, int prefixIndex, int currentVal, String currentExp, String prevOpe, long target, Set<String> res, int prevNumber) {
			
			if(prefixIndex>=nums.length()) {
				System.out.println(currentExp + "====" + currentVal);
				if(currentVal==target) {
					res.add(currentExp);
					
				}
				return;
			}
			int currentNumber = Integer.parseInt(nums.substring(prefixIndex, prefixIndex+1));
			
			evaluate(nums, prefixIndex+1, currentVal+currentNumber, currentExp+"+"+currentNumber,"plus",target, res, currentNumber);
			
			if(currentVal!=0) {
				if(prevOpe.equalsIgnoreCase("plus") && prefixIndex>0) {
					evaluate(nums, prefixIndex+1, currentVal-prevNumber+(prevNumber*10)+currentNumber, currentExp+currentNumber,prevOpe,target, res,(prevNumber*10)+currentNumber);
				}
				else if(prevOpe.equalsIgnoreCase("mul") && prefixIndex>0) {
					evaluate(nums, prefixIndex+1, (currentVal/prevNumber)*((prevNumber*10) + currentNumber), currentExp+currentNumber,prevOpe,target, res, (prevNumber*10)+currentNumber);
				}
				else {
					evaluate(nums, prefixIndex+1, (currentVal*10)+currentNumber, currentExp+currentNumber,prevOpe,target, res, (currentVal*10)+currentNumber);
				}
				
			}
			
			
			if(prevOpe.equalsIgnoreCase("plus") && prefixIndex>0) {
				evaluate(nums, prefixIndex+1, currentVal-prevNumber+(prevNumber*currentNumber), currentExp+"*"+currentNumber,"mul",target, res,currentNumber);
			}
			else {
				evaluate(nums, prefixIndex+1, currentVal-prevNumber+(prevNumber*currentNumber), currentExp+"*"+currentNumber,prevOpe,target, res,prevNumber);
			}
			
			
		}

}
