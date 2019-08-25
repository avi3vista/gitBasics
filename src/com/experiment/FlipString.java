package com.experiment;

/**
 * @author Avinash
 *
 */
/**
 * @author Avinash
 *
 */
public class FlipString {

	public static String flip(String input, Integer leftIndex) {
		StringBuffer sb = new StringBuffer(input);
		char ch = sb.charAt(leftIndex);
		sb.setCharAt(leftIndex, sb.charAt(leftIndex + 1));
		sb.setCharAt(leftIndex + 1, ch);
		return sb.toString();

	}

	/**
	 * @param start
	 * @param target
	 * @return
	 */
	public static Integer flip_to_transform(String start, String target) {
		int result = 0;
		while (!start.equals(target)) {
			for (int i = 0; i < start.length() - 2; i++) {
				if (start.charAt(i) != target.charAt(i)) {
					int index = start.indexOf(target.charAt(i));
					for (int j = index - 1; j >= i; j--) {
						start = flip(start, j);
						System.out.println(start + "       " + i);
						result++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ee = "Hello";

		String g = flip(ee, 3);
		System.out.println(g);
		int result = flip_to_transform("deductions", "discounted");
		System.out.println(result);
	}

}
