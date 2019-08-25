package com.experiment;

public class StringCompression {

	public static void main(String[] args) {
		
		String chars = "aabbccc";
		char[] charArray = {'a','b','c','d','e','f','g','g','g','g','g','g','g','g','g','g','g','g','a','b','c'};
		System.out.println(compress(charArray));
		charArray.length

	}

	private static int compress(char[] chars) {
		int index=0;
		char currentCharacter = 0;
		int count = 0;
		if(chars.length>0) {
			index=1;
			currentCharacter = chars[0];
			count++;
		}
		
		for(int i=1; i<chars.length; i++) {
			if(chars[i]==currentCharacter) {
				count++;
			}
			else {
				currentCharacter = chars[i];
				if(count!=1) {
					if(count>=100) {
						chars[index++] = Character.forDigit(count/100,10);
						count = count%100;
						if(count<10) {
							chars[index++] = 0;
						}
						if(count==0 || count==1) {
							chars[index++] = Character.forDigit(count,10);
						}
					}
					if(count>=10) {
						chars[index++]= Character.forDigit(count/10,10);
						count = count%10;
						if (count==0 || count==1) {
							chars[index++] = Character.forDigit(count,10);
						}
						
					}
					if(count>1) {
						chars[index++] = Character.forDigit(count,10);
						
					}
					chars[index++] = currentCharacter;
				}
				else if(count==1) {
					chars[index++] = currentCharacter;
				}
				count=1;
			}
		}
		if(count>=100) {
			chars[index++] = Character.forDigit(count/100,10);
			count = count%100;
			if(count<10) {
				chars[index++] = 0;
			}
			if(count==0 || count==1) {
				chars[index++] = Character.forDigit(count,10);
			}
		}
		if(count>=10) {
			chars[index++]= Character.forDigit(count/10,10);
			count = count%10;
			if (count==0 || count==1) {
				chars[index++] = Character.forDigit(count,10);
			}
			
		}
		if(count>1) {
			chars[index++] = Character.forDigit(count,10);
			
		}
		System.out.println("the new string = " + new String(chars));
		return index;
		
		
	}

}
