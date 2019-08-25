package com.experiment;

import java.text.BreakIterator;

public class BreakIteratorExperiment {
	
	public static void main(String[] args) {
		String inputString = "one two three four five";
		
		BreakIterator b = BreakIterator.getWordInstance();
		b.setText(inputString);
		
		StringBuffer sb = new StringBuffer();
		
		for (int end = b.last(), start=b.previous();start!=BreakIterator.DONE;end=start,start=b.previous()) {
			sb.append(inputString.substring(start,end));
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}

}
