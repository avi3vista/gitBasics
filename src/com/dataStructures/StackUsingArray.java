package com.dataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StackUsingArray {
	

	static final int Max = 1000;
	int top;
	int[] stack = new int[Max];
	
	
	boolean isEmpty() {
		boolean isEmpty = true;
		if(stack.length>0) {
			isEmpty=false;
		}
		
		return isEmpty;
	}
	
	
}
