package com.experiment;

public class OneEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(OneEditDistance("1203", "1213"));

	}

	private static boolean OneEditDistance(String string, String string2) {
		if(string.equals(string2)) {
			return false;
		}
		boolean isOneEditDistance = false;
		int distance = 0;

		String biggerString = string;
		String smallerString = string2;
		if (string2.length() > string.length()) {
			biggerString = string2;
			smallerString = string;
		}
		boolean increment = false;
		if (biggerString.length() - smallerString.length() > 1) {
			return isOneEditDistance;
		}

		if (biggerString.length() - smallerString.length() == 1) {
			increment = true;
		}

		for (int i = 0, j = 0; i < biggerString.length() && j < smallerString.length(); i++, j++) {
			if (biggerString.charAt(i) != smallerString.charAt(j)) {
				if (increment) {
					j--;
					increment = false;
				}
				distance++;
			}
			if (distance > 1) {
				return isOneEditDistance;
			}
		}
		isOneEditDistance = true;

		return isOneEditDistance;

	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// distance[i][j] is the distance converse word1(1~ith) to word2(1~jth)
		int[][] distance = new int[len1 + 1][len2 + 1];
		for (int j = 0; j <= len2; j++) {
			distance[0][j] = j;
		} // delete all characters in word2
		for (int i = 0; i <= len1; i++) {
			distance[i][0] = i;
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // ith & jth
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					distance[i][j] = Math.min(Math.min(distance[i][j - 1], distance[i - 1][j]), distance[i - 1][j - 1])
							+ 1;
				}
			}
		}
		return distance[len1][len2];
	}

}
