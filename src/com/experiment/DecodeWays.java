package com.experiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecodeWays {

	public static void main(String[] args) {
		Map<Integer, Character> refMap = new HashMap<Integer, Character>();

		refMap.put(1, 'A');
		refMap.put(2, 'B');
		refMap.put(3, 'C');
		refMap.put(4, 'D');
		refMap.put(5, 'E');
		refMap.put(6, 'F');
		refMap.put(7, 'G');
		refMap.put(8, 'H');
		refMap.put(9, 'I');
		refMap.put(10, 'J');
		refMap.put(11, 'K');
		refMap.put(12, 'L');
		refMap.put(13, 'M');
		refMap.put(14, 'N');
		refMap.put(15, 'O');
		refMap.put(16, 'P');
		refMap.put(17, 'Q');
		refMap.put(18, 'R');
		refMap.put(19, 'S');
		refMap.put(20, 'T');
		refMap.put(21, 'U');
		refMap.put(22, 'V');
		refMap.put(23, 'W');
		refMap.put(24, 'X');
		refMap.put(25, 'Y');
		refMap.put(26, 'Z');

		System.out.println(numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948", refMap));

	}

	public static int numDecodings(String s, Map<Integer, Character> refMap) {

		/*Integer count = 0;
		List<String> stringList = new ArrayList<String>();
		StringBuffer sb = new StringBuffer("");
		decode(0, s, count, refMap, stringList, sb);
		System.out.println(stringList);
		return stringList.size();*/
		if(s==null || s.length()==0 || s.charAt(0)==0) {
			return 0;
		}
		return decode01(s);
		
	}

	private static int decode01(String s) {
		
		if(s==null || s.length()==0 || s.charAt(0)=='0') {
			return 1;
		}
		
		if(s.length()==1) {
			return 1;
		}
		int count = 0;
		
		if(s.charAt(s.length()-1)!='0') {
			count = decode01(s.substring(0,s.length()-1));
		}
		if(s.charAt(s.length()-2)=='1' || (s.charAt(s.length()-2)=='2' && Integer.parseInt(s.substring(s.length()-1,s.length()))<7)) {
			count += decode01(s.substring(0,s.length()-2));
		}
		System.out.println("printing s " + s + "    count = " + count);
		return count;
	}

	private static void decode(int i, String s, Integer count, Map<Integer, Character> refMap, List<String> stringList,
			StringBuffer sb) {
		StringBuffer tempSb = new StringBuffer(sb);
		if (i < s.length()) {
			if(!refMap.containsKey(Integer.parseInt(s.substring(i, i + 1)))) {
				return;
			}
			if (Integer.parseInt(s.substring(i, i + 1)) == 0) {
				//stringList.clear();
				return;

			}
			if (i + 1 < s.length()
					&& Integer.parseInt(s.substring(i+1, i +2)) == 0) {
				if(!refMap.containsKey(Integer.parseInt(s.substring(i+1, i + 2)))) {
					return;
				}
				
				StringBuffer tempSb1 = new StringBuffer(sb);
				decode(i + 2, s, count, refMap, stringList,
						tempSb1.append(refMap.get(Integer.parseInt(s.substring(i, i + 2)))));

			}
			else {

				decode(i + 1, s, count, refMap, stringList,
						tempSb.append(refMap.get(Integer.parseInt(s.substring(i, i + 1)))));
				if (Integer.parseInt(s.substring(i, i + 1)) <= 2 && i + 1 < s.length()
						&& Integer.parseInt(s.substring(i + 1, i + 2)) <= 6) {
				
					if(!refMap.containsKey(Integer.parseInt(s.substring(i+1, i + 2)))) {
						return;
					}
					
					StringBuffer tempSb1 = new StringBuffer(sb);
					decode(i + 2, s, count, refMap, stringList,
							tempSb1.append(refMap.get(Integer.parseInt(s.substring(i, i + 2)))));
				}
			}
		} else {
			stringList.add(sb.toString());
		}

	}
}
