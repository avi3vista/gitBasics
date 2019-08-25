package com.dataStructures;

public class BinaryHeap {

	public static void main(String[] args) {
		
		int[] input = new int[16];
		
		int currentSize = 0;
		
		currentSize = insertIntoMinHeap(input,14,currentSize);
		currentSize = insertIntoMinHeap(input,5,currentSize);
		currentSize = insertIntoMinHeap(input,23,currentSize);
		currentSize = insertIntoMinHeap(input,17,currentSize);
		currentSize = insertIntoMinHeap(input,32,currentSize);
		currentSize = insertIntoMinHeap(input,41,currentSize);
		currentSize = insertIntoMinHeap(input,87,currentSize);
		currentSize = insertIntoMinHeap(input,25,currentSize);
		currentSize = insertIntoMinHeap(input,15,currentSize);
		currentSize = insertIntoMinHeap(input,99,currentSize);
		currentSize = insertIntoMinHeap(input,7,currentSize);
		currentSize = insertIntoMinHeap(input,10,currentSize);
		currentSize = insertIntoMinHeap(input,14,currentSize);
		
		
		printArray(input);

	}

	private static void printArray(int[] input) {
		for(int i: input)
			System.out.print(i + "    ");
			System.out.println();
		
	}

	private static int insertIntoMinHeap(int[] input, int toBeInsertedValue, int currentSize) {
		
		input[++currentSize] = toBeInsertedValue;
		
		heapifyUp(input, currentSize);
		
		
		return currentSize;
	}

	private static void heapifyUp(int[] input, int currentSize) {
		
		while(currentSize>1) {
			if(input[currentSize/2] > input[currentSize]) {
				int temp = input[currentSize];
				input[currentSize] = input[currentSize/2];
				input[currentSize/2] = temp;
				currentSize = currentSize/2;
			}
			else {
				break;
			}
		}
		
	}

}
