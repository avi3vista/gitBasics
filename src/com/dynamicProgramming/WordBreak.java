package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		String s="kickstartisawesome";
		List<String> dictionary = new ArrayList<String>();

		dictionary.add("kick");
		dictionary.add("start");
		dictionary.add("kickstart");
		dictionary.add("is");
		dictionary.add("awe");
		dictionary.add("some");
		dictionary.add("awesome");
		
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> curBreakUp = new ArrayList<String>();
		check(0,0,s,dictionary, res, curBreakUp);
		
		System.out.println(res);
		System.out.println(solver(7, dictionary,s));

	}
	public static List<String> solver(int dictionaryCount,List<String> dictionary, String txt) {
		
		List<String>[] memo = new ArrayList[txt.length()+1];
		for(int i=0; i<memo.length; i++) {
			memo[i] = new ArrayList<String>();
		}
		
		for(int i=1; i<memo.length; i++) {
			if(dictionary.contains(txt.substring(0,i))) {
				memo[i].add(txt.substring(0,i));
			}
			for(int j=0; j<=i; j++) {

				if(!memo[j].isEmpty() && dictionary.contains(txt.substring(j,i))) {
					for (String temp : memo[j]) {
						memo[i].add(temp + " " + txt.substring(j,i));
					}
				}
			}
		}
		
		return memo[memo.length-1];
		
    }

	private static void check(int i, int j, String s, List<String> dictionary, List<List<String>> res,
			List<String> curBreakUp) {
		
		if(i>=s.length()) {
			List<String> tempList = new ArrayList<String>();
			tempList.addAll(curBreakUp);
			res.add(tempList);
			return;
		}
		if(j>s.length()){
			return;
		}
		
		if(dictionary.contains(s.substring(i,j))) {
			curBreakUp.add(s.substring(i,j));
			check(j,j+1,s,dictionary,res,curBreakUp);
			curBreakUp.remove(curBreakUp.size()-1);
		}
		check(i,j+1,s,dictionary,res,curBreakUp);
		
		
	}

}
