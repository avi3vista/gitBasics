package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPathKeysAndDoors {

  public static void main(String[] args) {

    String[] grid = {"...B", ".b#.", "@#+."};
    
    find_shortest_path(grid);
  }
  
  static int[][] find_shortest_path(String[] grid) {
    char[][] mat = new char[grid.length][grid[0].length()];
    boolean[][] visited = new boolean[grid.length][grid[0].length()];
    for(int i=0; i<grid.length; i++) {
      mat[i] = grid[i].toCharArray();
    }
    
    Position start = findLocation(mat, '@');
    Position end = findLocation(mat, '+');
    
    Queue<Position> q = new LinkedList<Position>();
    
    q.add(start);
    
    /*'#' = Water.

        '.' = Land.

        'a' = Key of type 'a'. All lowercase letters are keys.

        'A' = Door that opens with key 'a'. All uppercase letters are doors.

        '@' = Starting cell.

        '+' = Ending cell (goal).*/
    Map<Character, Integer> keys = new HashMap<Character,Integer>();
    while(!q.isEmpty()) {
      Position cur = q.poll();
      visited[cur.row][cur.col]=true;
      
      if(cur.row>=mat.length || cur.row<0 || cur.col>=mat[0].length || cur.col<0) {
        continue;
      }
      
      if(cur.row==end.row && cur.col==end.col) {
        System.out.println("FOUND");
        Position temp = cur.parents.get(0);
        while(temp.parents.size()!=0) {
          System.out.println(temp.parents.get(0));
          temp = temp.parents.get(0);
        }
        
        continue;
      }
      
      if(mat[cur.row][cur.col]=='#') {
        continue;
      }
      if(Character.isLowerCase(mat[cur.row][cur.col])) {
        if (keys.containsKey(mat[cur.row][cur.col])) {
          keys.put(mat[cur.row][cur.col], keys.get(mat[cur.row][cur.col])+1);
        }
        else {
          keys.put(mat[cur.row][cur.col], 1);
        }
      }
      if((cur.row==start.row && cur.col==start.col)||(Character.isUpperCase(mat[cur.row][cur.col]) && keys.containsKey(Character.toLowerCase(mat[cur.row][cur.col]))) || mat[cur.row][cur.col]=='.' || (Character.isLowerCase(mat[cur.row][cur.col]))) {
        Position p = new Position(cur.row+1, cur.col);
        if(cur.row+1<mat.length && !visited[cur.row+1][cur.col]) {
          p.parents.add(cur);
          q.add(p);
      }
        p = new Position(cur.row-1, cur.col);
        if(cur.row-1>=0 && !visited[cur.row-1][cur.col]) {
          p.parents.add(cur);
          q.add(p);
      }
        
        p = new Position(cur.row, cur.col+1);
        if(cur.col+1<mat[0].length && !visited[cur.row][cur.col+1]) {
          p.parents.add(cur);
          q.add(p);
      }
        
        p = new Position(cur.row, cur.col-1);
        if(cur.col-1>=0 && !visited[cur.row][cur.col-1]) {
          p.parents.add(cur);
          q.add(p);
      }
      }
      
    }
      return null;

  }
  
  private static Position findLocation(char[][] mat, char c) {
    for(int i=0; i<mat.length; i++) {
      for(int j=0; j<mat[i].length; j++) {
        if(mat[i][j]==c) {
          return new Position(i, j);
        }
      }
    }
    return null;
  }

  public static class Position {
    int row;
    int col;
    List<Position> parents;
    
    public Position(int row, int col, List<Position> parents) {
      super();
      this.row = row;
      this.col = col;
      this.parents = parents;
    }
    
    public Position(int row, int col) {
      super();
      this.row = row;
      this.col = col;
      this.parents = new ArrayList<Position>();
    }
    
    @Override
    public String toString() {
      return this.row+","+this.col;
    }
    
    
  }
  
  

}
