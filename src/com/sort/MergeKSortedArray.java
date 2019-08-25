package com.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray {

	public static void main(String[] args) {
		
		int arr[][] = { {1, 3, 5, 7},

		           {2, 4, 6, 8},

		           {0, 9, 10, 11}} ;
		int output[] = mergeArrays(arr);
		for(int i: output)
		System.out.print(i + "  ");

	}
	
	static int[] mergeArrays(int[][] arr) {
		if(arr==null || arr.length==0) {
			return null;
		}
		int k = arr.length;
		int n = arr[0].length;
		
		Comparator<ArrayContainer> customComparator = new Comparator<ArrayContainer>() {
			
			@Override
			public int compare(ArrayContainer a1, ArrayContainer a2) {
				return arr[a1.arrayId][a1.currentIndex]>arr[a2.arrayId][a2.currentIndex] ? 1 : -1;
			}
		};
		
		Queue<ArrayContainer> q = new PriorityQueue<ArrayContainer> (k,customComparator);
		for(int i=0; i<k; i++) {
			ArrayContainer a = new ArrayContainer(i,0);
			q.offer(a);
			
		}
		
		int output[] = new int[k * n];
		int outputIndex =0;
		
		while(!q.isEmpty()) {
			ArrayContainer ac = q.poll();
			output[outputIndex++] = arr[ac.arrayId][ac.currentIndex];
			ac.currentIndex++;
			if(ac.currentIndex<n) {
				q.offer(ac);
			}
			
		}
		
		return output;

    }
	
	static class ArrayContainer {
		int arrayId;
		int currentIndex;
		
		public ArrayContainer(int arrayId, int currentIndex) {
			this.arrayId = arrayId;
			this.currentIndex = currentIndex;
		}
	}

}
