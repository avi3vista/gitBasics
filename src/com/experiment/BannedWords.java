package com.experiment;

import java.util.HashMap;
import java.util.Map;

public class BannedWords {
	public static void main(String[] args) {
		
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String[] banned = {"a"};
		
		String commonWord = mostCommonWord(paragraph, banned);
		System.out.println("most common word = " + commonWord);

	}

	private static String mostCommonWord(String paragraph, String[] banned) {
		String mostCommonWord = "";
		String paragraph1 = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().trim();
		for(int i=0; i<banned.length; i++) {
			paragraph1 = paragraph1.replaceAll(banned[i], "");
		}
		
		String[] words = paragraph1.trim().split("\\s+");
		Map<String, Integer> count = new HashMap<String, Integer>();
		
		for(int i=0; i<words.length; i++) {
			if(count.containsKey(words[i].trim())) {
				count.put(words[i].trim(), count.get(words[i])+1);
			}
			else {
				count.put(words[i].trim(),1);
			}
		}
		int maxCount = 0;
		for(String key : count.keySet()) {
			if(count.get(key)>maxCount) {
				mostCommonWord = key;
				maxCount = count.get(key);
			}
		}
		
		
		
		return mostCommonWord;
		
		
	}
}
