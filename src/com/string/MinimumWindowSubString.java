package com.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MinimumWindowSubString {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		System.out.println(minWindow03(s, "CABC"));

	}
	
	public static String minWindow03(String givenString, String toBeChecked) {
		String res = "";
		
		Map<Character, Integer> refMap = new HashMap<Character, Integer>();
		int index=0;
		for(char c : toBeChecked.toCharArray()) {
			if(!refMap.containsKey(c)) {
				refMap.put(c, index++);
			}
		}
		int[] countArr = new int[refMap.size()];
		int missing = 0;
		for(char c : toBeChecked.toCharArray()) {
			countArr[refMap.get(c)]++;
			missing++;
		}
		
		int lt=0, rt=0, si=0, min=-1;
		
		while (rt<givenString.length()) {
			if(refMap.containsKey(givenString.charAt(rt))) {
				countArr[refMap.get(givenString.charAt(rt))]--;
			
			if(countArr[refMap.get(givenString.charAt(rt))]>=0) {
				missing--;
			}
			}
			rt++;
			
			while(missing==0) {
				if(rt-lt<min ||  min==-1) {
					min = rt-lt;
					si=lt;
				}
				if(refMap.containsKey(givenString.charAt(lt))) {
					countArr[refMap.get(givenString.charAt(lt))]++;
				
				if(countArr[refMap.get(givenString.charAt(lt))]>0) {
					missing++;
				}
				}
				lt++;
			}
		}
		if(min!=-1) {
			res = givenString.substring(si, si+min);
		}
		
		
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static String minWindow(String givenString, String tobeCheckedString) {
		String res="";
		Map<Character, Integer> refMap = new HashMap<Character,Integer>();
		int index = 0;
		for(char c : tobeCheckedString.toCharArray()) {
			if(!refMap.containsKey(c)) {
				refMap.put(c, index++);
			}
		}
		
		int[] countArr = new int[refMap.size()];
		for(char c : tobeCheckedString.toCharArray()) {
			countArr[refMap.get(c)]++;
		}
		int missing = tobeCheckedString.length();
		
		int lt=0, rt=0, head=0, min=-1;
		
		while(rt<givenString.length()) {
			if(refMap.containsKey(givenString.charAt(rt))) {
				if(countArr[refMap.get(givenString.charAt(rt))]>0) {
				missing--;
				}
				countArr[refMap.get(givenString.charAt(rt))]--;
			}
			rt++;
			while(missing==0) {
				if(rt-lt<min || min==-1) {
					min=rt-lt;
					head=lt;
				}
				if(refMap.containsKey(givenString.charAt(lt))) {
					if(countArr[refMap.get(givenString.charAt(lt))]==0) {
					missing++;
					}
					countArr[refMap.get(givenString.charAt(lt))]++;
				}
				lt++;
			}
		}
		if(min!=-1) {
			res = givenString.substring(head,head+min);
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static String minWindowFromLeetCode(String givenString, String tobeCheckedString) {
		
		int[] map = new int[128];

		for (char c : tobeCheckedString.toCharArray())
			map[c]++;

		int missingCount = tobeCheckedString.length(), leftPointer = 0, rightPointer = 0, minLength = Integer.MAX_VALUE, startIndex = 0;

		while (rightPointer < givenString.length()) {
			if (map[givenString.charAt(rightPointer)] > 0){
				missingCount--;
			}
			map[givenString.charAt(rightPointer)]--;
			rightPointer++;
			
			while (missingCount == 0) {
				if (rightPointer - leftPointer < minLength) {
					minLength = rightPointer - leftPointer;
					startIndex = leftPointer;
				}
				if (map[givenString.charAt(leftPointer)] == 0)
					missingCount++;
				map[givenString.charAt(leftPointer)]++;
				leftPointer++;
			}
		}

		return minLength == Integer.MAX_VALUE ? "" : givenString.substring(startIndex, startIndex + minLength);
    }

	private static String minWindowFirstAttempt(String s, String t) {
		String res = "";
		int sIdx = -1;
		int eIdx = -1;
		int min = -1;
		int lt = 0;
		int rt = 0;
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		frequency.put(s.charAt(lt), 1);

		while (rt <= s.length() - 1) {
			if (containSequence(frequency, t)) {
				if ((rt - lt) < min || min == -1) {
					sIdx = lt;
					eIdx = rt;
					min = rt - lt;

				}
				int t1;
				t1 = frequency.get(s.charAt(lt)) == 1 ? frequency.remove(s.charAt(lt))
						: frequency.put(s.charAt(lt), frequency.get(s.charAt(lt)) - 1);
				lt++;
			} else {
				rt++;
				if (rt <= s.length() - 1) {
					if (frequency.containsKey(s.charAt(rt))) {
						frequency.put(s.charAt(rt), frequency.get(s.charAt(rt)) + 1);
					} else {
						frequency.put(s.charAt(rt), 1);
					}
				}
			}
		}
		if (sIdx != -1 && eIdx != -1) {
			res = s.substring(sIdx, eIdx + 1);
		}
		return res;

	}

	private static boolean containSequence(Map<Character, Integer> frequency, String t) {
		boolean contains = true;
		int i = 0;
		for (i = 0; i < t.length(); i++) {
			if (!frequency.containsKey(t.charAt(i))) {
				contains = false;
				break;
			} else {
				int f = frequency.get(t.charAt(i));
				if (f == 1) {
					frequency.remove(t.charAt(i));
				} else {
					frequency.put(t.charAt(i), f - 1);
				}
			}
		}

		for (int j = 0; j < i; j++) {
			if (frequency.containsKey(t.charAt(j))) {
				frequency.put(t.charAt(j), frequency.get(t.charAt(j)) + 1);
			} else {
				frequency.put(t.charAt(j), 1);
			}
		}

		return contains;
	}

}
