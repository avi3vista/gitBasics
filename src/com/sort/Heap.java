package com.sort;

public class Heap {
	static int arr[] = {3,4,21,41,31,66,30};
	
	static int heap[] = new int[arr.length+1];
	static int size = 0;
	public static void main(String[] args) {
		
		
		for(int i=0; i<arr.length; i++) {
			insert(arr[i], heap);
		}
		for(int i: heap){
			System.out.print(i + "  ");
		}
		System.out.println();
		
		deleteMin();

	}

	private static void deleteMin() {
		System.out.println("deleting min " + heap[1] );
		heap[1]=heap[size--];
		heapifyDown(1);
		System.out.print("current heap is     ");
		for(int i=1; i<=size; i++) {
			System.out.print(heap[i] + "  ");
		}
		System.out.println();
		
	}

	private static void heapifyDown(int i) {
		while(2*i<=size) {
			int min = 2*i;
			if(2*i+1<=size) {
				min = heap[2*1]>heap[2*i+1] ? 2*i : 2*i+1;						
			}
			if(heap[i]>heap[min]) {
				swap(heap, i , min);
				i=min;
			}
			
		}
		
	}

	private static void insert(int i, int[] heap) {
		heap[++size]=i;
		heapifyUp(size);
		
	}

	private static void heapifyUp(int i) {
		
		while(i>1 && heap[i]<heap[i/2]) {
			swap(heap, i, i/2);
			i=i/2;
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}

}
