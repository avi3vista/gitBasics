package com.experiment;

import java.util.Arrays;

public class NextClosestTime {

	public static void main(String[] args) {
		
		String time = "23:59";
		
		System.out.println("next closest time is " + nextClosestTime(time));

	}

	public static String nextClosestTime(String time) {
		
		char[] charArray = time.toCharArray();
		int[] numbers = new int[4];
		numbers[0]= Character.getNumericValue(charArray[0]);
		numbers[1]= Character.getNumericValue(charArray[1]);
		numbers[2]= Character.getNumericValue(charArray[3]);
		numbers[3]= Character.getNumericValue(charArray[4]);
		Arrays.sort(numbers);
		
		for(int i=0; i<4; i++) {
			if(numbers[i]>Character.getNumericValue(charArray[4])) {
				charArray[4] = Character.forDigit(numbers[i],10);
				return new String(charArray);
			}
		}
		for(int i=0; i<4; i++) {
			if(numbers[i]>Character.getNumericValue(charArray[3]) && numbers[i]<6) {
				charArray[3] = Character.forDigit(numbers[i],10);
				charArray[4] = (char)numbers[0];
				return new String(charArray);
			}
		}
		for(int i=0; i<4; i++) {
			if(Character.getNumericValue(charArray[0])<2 && numbers[i]>Character.getNumericValue(charArray[1])) {
				charArray[1] = Character.forDigit(numbers[i],10);
				charArray[3] = Character.forDigit(numbers[0],10);
				charArray[4] = Character.forDigit(numbers[0],10);
				return new String(charArray);
			}
			if(Character.getNumericValue(charArray[0])==2 && numbers[i]>Character.getNumericValue(charArray[1]) && numbers[i]<5) {
				charArray[1] = Character.forDigit(numbers[i],10);
				charArray[3] = Character.forDigit(numbers[0],10);
				charArray[4] = (char)numbers[0];
				return new String(charArray);
			}
		}
		for(int i=0; i<4; i++) {
			if(numbers[i]>Character.getNumericValue(charArray[0]) && numbers[i]<3) {
				charArray[0] = Character.forDigit(numbers[i],10);
				charArray[1] = Character.forDigit(numbers[0],10);
				charArray[3] = Character.forDigit(numbers[0],10);
				charArray[4] = (char)numbers[0];
				return new String(charArray);
			}
		}
		charArray[0] = Character.forDigit(numbers[0],10);
		charArray[1] = Character.forDigit(numbers[0],10);
		charArray[3] = Character.forDigit(numbers[0],10);
		charArray[4] = Character.forDigit(numbers[0],10);
		
		return new String(charArray);

	}

}
