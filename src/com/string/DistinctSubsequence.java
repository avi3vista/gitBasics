package com.string;

public class DistinctSubsequence {

	public static void main(String[] args) {
		
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String t = "bcddceeeebecbc";
		
		System.out.println(numDistinct(s,t));

	}
	
	public static int numDistinct(String s, String t) {
        int[] count = new int[1];
	    char[] c1 = s.toCharArray();
	    check(c1, t, 0, "", count);
	    return count[0];
    }
    
    public static void check (char[] c1, String t, int i1, String res, int[] count) {
    	if(res.length()>t.length()) {
    		return;
    	}
	if(i1>=c1.length || res.length()==t.length()) {
		if(res.toString().equals(t)) {
			count[0]++;
		}
		return;
	}
	

	if(t.charAt(res.length())==c1[i1]) {
		check(c1, t, i1+1, res+c1[i1], count);
	}
	check(c1, t, i1+1, res, count);
}

}
