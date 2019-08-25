package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Knightstour {

  public static void main(String[] args) {

    int rows = 33333;
    int cols = 3;


    int start_row = 333;

    int start_col = 0;

    int end_row = 33332;

    int end_col = 2;

    System.out
        .println(find_minimum_number_of_moves_opt(rows, cols, start_row, start_col, end_row, end_col));

  }
  
  
  static int find_minimum_number_of_moves_opt(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
    
    List<Positions> graph[][] = new ArrayList[rows][cols];



    Queue<Positions> queue = new LinkedList<>();

    queue.add(new Positions(start_row, start_col, 0));
    boolean visited[][] = new boolean[rows][cols];

    while (!queue.isEmpty()) {
      Positions temp = queue.poll();
      visited[temp.row][temp.column] = true;
      if (temp.row == end_row && temp.column == end_col) {
        return temp.level;
      }
      int i=temp.row;
      int j = temp.column;
      int level = temp.level;
      
      
      if (i - 1 >= 0) {
          if (j - 2 >= 0 && !visited[i-1][j-2]) {
            visited[i-1][j-2] = true;
            queue.add(new Positions(i - 1, j - 2, level+1));
          }
          if (j + 2 < cols  && !visited[i-1][j+2]) {
            visited[i-1][j+2] = true;
            queue.add(new Positions(i - 1, j + 2, level+1));
          }
        }
        if (i - 2 >= 0) {
          if (j - 1 >= 0 && !visited[i-2][j-1]) {
            visited[i-2][j-1] = true;
            queue.add(new Positions(i - 2, j - 1, level+1));
          }
          if (j + 1 < cols && !visited[i-2][j+1]) {
            visited[i-2][j+1] = true;
            queue.add(new Positions(i - 2, j + 1, level+1));
          }
        }

        if (i + 1 < rows) {
          if (j - 2 >= 0 && !visited[i+1][j-2]) {
            visited[i+1][j-2] = true;
            queue.add(new Positions(i + 1, j - 2, level+1));
          }
          if (j + 2 < cols && !visited[i+1][j+2]) {
            visited[i+1][j+2] = true;
            queue.add(new Positions(i + 1, j + 2, level+1));
          }
        }
        if (i + 2 < rows) {
          if (j - 1 >= 0 && !visited[i+2][j-1]) {
            visited[i+2][j-1] = true;
            queue.add(new Positions(i + 2, j - 1, level+1));
          }
          if (j + 1 < cols && !visited[i+2][j+1]) {
            visited[i+2][j+1] = true;
            queue.add(new Positions(i + 2, j + 1, level+1));
          }
        }
    }
    return -1;


    }
  

  static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col,
      int end_row, int end_col) {
    /* List<Positions> graph[][] = new ArrayList[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        graph[i][j] = new ArrayList<Positions>();
      }
    }


    int res = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i - 1 >= 0) {
          if (j - 2 >= 0) {
            graph[i][j].add(new Positions(i - 1, j - 2, ));
          }
          if (j + 2 < cols) {
            graph[i][j].add(new Positions(i - 1, j + 2));
          }
        }
        if (i - 2 >= 0) {
          if (j - 1 >= 0) {
            graph[i][j].add(new Positions(i - 2, j - 1));
          }
          if (j + 1 < cols) {
            graph[i][j].add(new Positions(i - 2, j + 1));
          }
        }

        if (i + 1 < rows) {
          if (j - 2 >= 0) {
            graph[i][j].add(new Positions(i + 1, j - 2));
          }
          if (j + 2 < cols) {
            graph[i][j].add(new Positions(i + 1, j + 2));
          }
        }
        if (i + 2 < rows) {
          if (j - 1 >= 0) {
            graph[i][j].add(new Positions(i + 2, j - 1));
          }
          if (j + 1 < cols) {
            graph[i][j].add(new Positions(i + 2, j + 1));
          }
        }
      }
    }
    printMatrix(graph);

    Queue<Positions> queue = new LinkedList<>();

    queue.add(new Positions(start_row, start_col));

    queue.add(new Positions(-1, -1));
    boolean visited[][] = new boolean[rows][cols];

    while (!queue.isEmpty()) {
      Positions temp = queue.poll();
      if (temp.row == -1) {
        res++;
        if (!queue.isEmpty()) {
          queue.add(temp);
        }
        continue;
      }
      visited[temp.row][temp.column] = true;
      if (temp.row == end_row && temp.column == end_col) {
        return res;
      }

      for (Positions curPosition : graph[temp.row][temp.column]) {
        if (!visited[curPosition.row][curPosition.column]) {
          queue.add(curPosition);
        }
      }
    }*/
    return -1;


  }

  private static void printMatrix(List<Positions>[][] graph) {
    System.out.println("======================================");
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        System.out.print(graph[i][j] + "  ");
      }
      System.out.println();
    }
    System.out.println("======================================");
  }

  static class Positions {
    int row;
    int column;
    int level;

    public Positions(int row, int column, int level) {
      super();
      this.row = row;
      this.column = column;
      this.level = level;
    }

    public String toString() {
      String res = this.row + "," + this.column + "," + this.level;
      return res;
    }

  }


  public static void printMatrix(int[][] grid) {
    System.out.println("======================================");
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + "  ");
      }
      System.out.println();
    }
    System.out.println("======================================");
  }

}
