package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {

  public static void main(String[] args) {
      final int INF = 2147483647;
      
      int[][] rooms = {{INF,-1,0,INF},
                        {INF,INF,INF,-1},
                        {INF,-1,INF,-1},
                         {0,  -1, INF, INF}};
      printMatrix(rooms);
      
      
      wallsAndGates(rooms);
      
      printMatrix(rooms);
      
      
  }
  
  public static void wallsAndGates(int[][] rooms) {
    final int INF = 2147483647;
    Queue<int[]> q = new LinkedList<int[]>();
    for(int i=0; i<rooms.length; i++) {
      for (int j=0; j<rooms[0].length; j++) {
        if(rooms[i][j]==0) {
          q.add(new int[] {i,j});
        }
      }
    }
    
    List<int[]> directions = new ArrayList<int[]>();
    directions.add(new int[] {1,0});
    directions.add(new int[] {-1,0});
    directions.add(new int[] {0,1});
    directions.add(new int[] {0,-1});
    
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      
      for(int[] d : directions) {
        int r = cur[0]+d[0];
        int c = cur[1]+d[1];
        
        if(r<0 || r>=rooms.length || c<0 || c>=rooms[0].length) {
          continue;
        }
        if(rooms[r][c]==INF) {
          rooms[r][c]=rooms[cur[0]][cur[1]] +1;
          q.add(new int[]{r,c});
        }
      }
      
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
