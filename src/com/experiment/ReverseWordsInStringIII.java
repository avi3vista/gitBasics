package com.experiment;

public class ReverseWordsInStringIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = " ";
		
		System.out.println("Reversed words are " + reverseWords(inputString));
		

	}
	
	public static String reverseWords(String s) {
        if(s!=null) {
        	StringBuffer outputString = new StringBuffer();
            
            String[] inputStringArray = s.split(" ");
            if(inputStringArray.length>0) {
            outputString = outputString.append(reverseCharacters(inputStringArray[0]));
            for(int i=1;i<inputStringArray.length;i++) {
            	outputString =outputString.append(" ").append(reverseCharacters(inputStringArray[i]));
            }
            }
            
            
            return outputString.toString();
        }
        else {
        	return s;
        }

    }

	private static StringBuffer reverseCharacters(String string) {
		if(string!=null && !string.equalsIgnoreCase("")){
			StringBuffer outputString = new StringBuffer();
		    
		    for(int i=string.length()-1;i>=0;i--) {
		    	outputString.append(string.charAt(i));
		    }
		    
		    return outputString;
		}
		else {
			return new StringBuffer(string);
		}
	}

}
