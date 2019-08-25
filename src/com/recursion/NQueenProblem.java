package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblem {

	public static void main(String[] args) {
		int n=4;
		
		String[][] res = find_all_arrangements(n);

	}

	private static String[][] find_all_arrangements(int n) {
      List<Position> currentPositions = new ArrayList<Position>();
	  
      List<List<Position>> res = new ArrayList<List<Position>>();
      
      findRecursive(0, n, currentPositions, res);
      
      String[][] resString = convertListToStringArray(res,n);
	  for(String[] sArr : resString) {
	    for (String s : sArr) {
	      System.out.println(s);
	    }
	    System.out.println("==============");
	  }
      System.out.println(resString);
	  return resString;
    
    
  }
	
	private static void findRecursive(int currentRow, int n, List<Position> currentPositions,
      List<List<Position>> res) {
	  
	  if(currentRow>=n) {
	    res.add(new ArrayList<Position>(currentPositions));
	    return;
	  }
	  for(int i=0; i<n; i++) {
	    if(colCheck(currentRow, i, currentPositions) && incDiagCheck(currentRow, i, currentPositions) && decDiagCheck(currentRow, i, currentPositions)) {
	      currentPositions.add(new Position(currentRow, i));
	      findRecursive(currentRow+1, n, currentPositions, res);
	      currentPositions.remove(currentPositions.size()-1);
	    }
	  }
	  return;
    
  }

  private static boolean decDiagCheck(int currentRow, int i, List<Position> currentPositions) {
    int diff = currentRow-i;
    for(Position p : currentPositions) {
      if(p.row-p.col==diff) {
        return false;
      }
    }
    return true;
  }

  private static boolean incDiagCheck(int currentRow, int i, List<Position> currentPositions) {
    int sum = currentRow+ i;
    for(Position p : currentPositions) {
      if(p.col+p.row==sum) {
        return false;
      }
    }
    return true;
  }

  private static boolean colCheck(int currentRow, int currentCol, List<Position> currentPositions) {
    for(Position p : currentPositions) {
      if(currentCol==p.col) {
        return false;
      }
    }
    return true;
  }

  private static String[][] convertListToStringArray(List<List<Position>> res, int n) {
    System.out.println(res);
    if(res==null || res.size()==0) {
      return new String[0][0];
    }
    String[][] resSt = new String[res.size()][res.get(0).size()];
    char[] initializeChar = new char[n];
    for(int i=0; i<initializeChar.length; i++) {
      initializeChar[i]='-';
    }
    String everyRow = new String(initializeChar);
    String[] matrix = new String[n];
    for(int i=0; i<matrix.length; i++) {
      matrix[i] = everyRow;
    }
    for(int i=0; i<resSt.length; i++) {
      resSt[i] = Arrays.copyOf(matrix, matrix.length);
    }
    for(int i=0; i<res.size(); i++) {
      for(int j=0; j<res.get(i).size(); j++) {
        Position temp = res.get(i).get(j);
        String[] resTemp = resSt[i];
        char[] resChar = resTemp[temp.row].toCharArray();
        resChar[temp.col]='q';
        resTemp[temp.row] = new String(resChar);
      }
    }
    
    return resSt;
  }

  static class Position {
	  int row;
	  int col;
	  public Position(int row, int col) {
	    this.row = row;
	    this.col = col;
      }
	  @Override
	  public String toString() {
	  return this.row + "," + this.col;
	  }
	}

  /*private static String[][] find_all_arrangements(int n) {
		List<String[]> res  = new ArrayList<String[]>();
		String[][] mat = new String[n][n];
		find_all_arrangements(n, mat, 0, res);
		
		if(res.size()==0) {
		  return null;
		}
		
		String[][] resArr = new String[res.size()][n];
		for(int i=0; i<res.size(); i++) {
		  resArr[i] = res.get(i);
		}
		
		return  resArr;
	}
	
	private static void find_all_arrangements(int n, String[][] mat, int row, List<String[]> res) {
	  
	  if(row>=mat.length && n==0) {
	    String[] curRes = new String[mat.length];
	    for (int i=0; i<mat.length; i++) {
	      StringBuffer curRow = new StringBuffer("");
	      for(int j=0; j<mat.length; j++) {
	        curRow.append(mat[i][j]);
	      }
	      curRes[i] = curRow.toString();
	    }
	    res.add(curRes);
	  }
	  
	  for(int i=row; i<mat.length; i++) {
	    boolean isFound = false;
	    for(int j=0; j<mat.length; j++) {
	      if(mat[i][j]!=null) {
	        continue;
	      }
	      isFound=true;
	      List<Positions> currentVisibility = new ArrayList<Positions>();
	      mat[i][j]="q";
	      markVisibility(mat, i, j, currentVisibility);
	      find_all_arrangements(n-1, mat, i+1, res);
	      mat[i][j]=null;
	      unMarkVisibility(mat, currentVisibility);
	    }
	    if(!isFound) {
	      return;
	    }
	  }
    
  }
	
	private static void unMarkVisibility(String[][] mat, List<Positions> currentVisibility) {
	  
	  for(Positions p : currentVisibility) {
	    mat[p.row][p.col] = null;
	  }
    
  }

  private static void markVisibility(String[][] mat, int curRow, int curCol,
      List<Positions> currentVisibility) {
    
    for(int i=0; i<mat.length; i++) {
      if(mat[curRow][i]==null) {
        mat[curRow][i]="-";
        currentVisibility.add(new Positions(curRow,i));
      }
    }
    for(int i=0; i<mat.length; i++) {
      if(mat[i][curCol]==null) {
        mat[i][curCol]="-";
        currentVisibility.add(new Positions(i, curCol));
      }
    }
    
    //leftTop
    int i= curRow;
    int j = curCol;
    while(i>=0 && j>=0) {
      if(mat[i][j]==null) {
        mat[i][j]="-";
        currentVisibility.add(new Positions(i, j));
      }
      i--;
      j--;
      
    }
    
  //rightTop
    i= curRow;
    j = curCol;
    while(i>=0 && j<mat.length) {
      if(mat[i][j]==null) {
        mat[i][j]="-";
        currentVisibility.add(new Positions(i, j));
      }
      i--;
      j++;
      
    }
    
  //leftBottom
    i= curRow;
    j = curCol;
    while(i<mat.length && j>=0) {
      if(mat[i][j]==null) {
        mat[i][j]="-";
        currentVisibility.add(new Positions(i, j));
      }
      i++;
      j--;
      
    }
  //rightBottom
    i= curRow;
    j = curCol;
    while(i<mat.length && j<mat.length) {
      if(mat[i][j]==null) {
        mat[i][j]="-";
        currentVisibility.add(new Positions(i, j));
      }
      i++;
      j++;
      
    }
    
    
  }*/

  public static void printMatrix(String[][] grid) {
      System.out.println("======================================");
      for (int i = 0; i < grid.length; i++) {
          for (int j = 0; j < grid[0].length; j++) {
              System.out.print(grid[i][j] + "  ");
          }
          System.out.println();
      }
      System.out.println("======================================");
  }

  static class Positions {
	  int row;
	  int col;
    public Positions(int row, int col) {
      super();
      this.row = row;
      this.col = col;
    }
    
    @Override
    public String toString() {
      return this.row+","+this.col;
    }
	  
	  
	  
	  
	}

	

}
