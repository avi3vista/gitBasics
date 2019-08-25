package com.experiment;

public class FlippingAnImage {

	public static void main(String[] args) {
		
		int[][] input = {{1,1,0},{1,0,1},{0,0,0}};
		
		for(int i=0; i<input.length; i++) {
			for (int j=0; j<input[i].length; j++) {
				System.out.print(input[i][j] + "    ");
			}
			System.out.println();
		}
		
		System.out.println("=====================================");
		
		flipAndInvertImage(input);
		
		for(int i=0; i<input.length; i++) {
			for (int j=0; j<input[i].length; j++) {
				System.out.print(input[i][j] + "    ");
			}
			System.out.println();
		}

	}
	
public static int[][] flipAndInvertImage(int[][] A) {
     
	for(int i=0; i<A.length; i++) {
		int low = 0;
		int high = A[i].length-1;
		int temp = 0;
		while (low<=high) {
			temp=A[i][low];
			if(A[i][high]==0) {
				A[i][low]=1;
			}
			else {
				A[i][low]=0;
			}
			if(temp==0) {
				A[i][high]=1;
			}
			else {
				A[i][high]=0;
			}
			high--;
			low++;
		}
	}
	
	return A;
    }

}
