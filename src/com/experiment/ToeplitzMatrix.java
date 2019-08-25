package com.experiment;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		
		for(int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println(isToeplitzMatrix(matrix));
		
		

	}
	
	public static boolean isToeplitzMatrix(int[][] matrix) {
        boolean isToeplitz = false;
        /*for(int k=0; k<matrix.length;k++) {
			int i=k;
			int j=0;
			while(i>=0) {
				System.out.print(matrix[i][j]);
				i--;
				j++;
			}
        	
        	
        	
		}*/
        /*int columns = matrix[0].length;
        int rows = matrix.length;
        int i=0;
        int j=0;
        for(int k=columns-1; k>=0;k--) {
        	j=k;
        	i=0;
        	while(j<columns && i<rows) {
        		System.out.println(i+" " +j);
        		i++;
        		j++;
        	}
        	System.out.println("=================");
        }*/
        
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    
        
    }
	
	

}
