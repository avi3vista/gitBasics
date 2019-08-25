package com.experiment;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		
		String s = "2-5g-3-J";
		int k = 2;
		
		System.out.println("formatted string is " + licenseKeyFormatting(s, k));
				

	}

	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder(S.replaceAll("-", ""));
		int firstGroupLength = sb.length() % K == 0 ? K : sb.length() % K;
		sb.insert(firstGroupLength, "-");
		for(int i=firstGroupLength+K+1; i<sb.length(); i=i+K+1) {
			sb.insert(i, "-");
		}
		return sb.toString();
	}

}
