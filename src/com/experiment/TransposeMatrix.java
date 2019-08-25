package com.experiment;

public class TransposeMatrix {

	public static void main(String[] args) {
		
		
		
		int[][] input = {{1,2,3,11},{4,5,6,22},{7,8,9,33}};

		for(int i=0; i<input.length; i++) {
			for (int j=0; j<input[i].length; j++) {
				System.out.print(input[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("=======================================");
		int[][] result = transpose(input);
		
		for(int i=0; i<result.length; i++) {
			for (int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static int[][] transpose(int[][] A) {
		if(A.length==0) {
			return A;
		}
		int[][] result = new int[A[0].length][A.length];
		
		for(int i=0; i<A.length; i++) {
			for (int j=0; j<A[i].length; j++) {
				result[j][i]=A[i][j];
			}
		}
		return result;
        
    }

}
