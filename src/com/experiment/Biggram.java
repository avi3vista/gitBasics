package com.experiment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

public class Biggram {
	
	public static void main(String[] args) {
		String inputText = "The quick brown fox and the quick blue hare.";
		 inputText = inputText.replaceAll("[-+.^:,]","");
		
		String[] splitedInput = inputText.split(" ");
		
		Map<String,Integer> resultMap = new HashMap();
		
		String currentBigram = "";
		for(int i=0;i<splitedInput.length-1; i++) {
			currentBigram=splitedInput[i]+" "+splitedInput[i+1];
			if(resultMap.containsKey(currentBigram.toLowerCase()))
				resultMap.put(currentBigram, resultMap.get(currentBigram.toLowerCase())+1);
			else
				resultMap.put(currentBigram.toLowerCase(),1);		
			
		}
		 Iterator it = resultMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		
		
	}
	}
