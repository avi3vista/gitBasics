package com.experiment;

import java.util.ArrayList;
import java.util.List;

public class StringDFS {

	public static void main(String[] args) {
		
		List<String> inputListOfStrings = new ArrayList<String>();
		
		inputListOfStrings.add("ABCD");
		inputListOfStrings.add("EFGH");
		inputListOfStrings.add("IJKL");
		
		dfs(inputListOfStrings, "", 0);

	}

	private static void dfs(List<String> inputListOfStrings, String existingString, int index) {
		List<String> tempList = inputListOfStrings;
		
		if(tempList.size()-1==index) {
			for(int i=0;i<inputListOfStrings.get(index).length(); i++) {
				System.out.println(existingString+inputListOfStrings.get(index).charAt(i));
			}
			return;
		} 
		index++;
		for (int i=0; i<inputListOfStrings.size();i++) {
			dfs(inputListOfStrings,existingString,index);
		}
		
	}

}
