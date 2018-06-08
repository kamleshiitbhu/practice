import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    
    static int[] movx = {-1,0,0,1,-1,-1,1,1};
    static int[] movy = {0,-1,1,0,1,-1,-1,1};
    static int globalCount = Integer.MIN_VALUE;
    
    static boolean isValid(int row, int col,int ROW,int COL)
    {
        // return true if row number and column number is in range
        return (row >= 0) && (row < ROW) &&
               (col >= 0) && (col < COL);
    }
    
    public static int getBiggestRegion(int[][] grid,int n, int m) {
        boolean visited[][] = new boolean[n][m];
        Stack<Point> stack = new Stack<>();
        int nextx;
        int nexty;
        for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
               
              if(grid[i][j] == 1 && !visited[i][j]){
                  Point current = new Point(i,j,grid[i][j]);
                  stack.push(current);
                  int count = 1;
                  while(!stack.isEmpty()){
                      stack.pop();
                      for(int k=0;k<8;k++){
                          nextx = i + movx[k];
                          nexty = j + movy[k];
                          if(isValid(nextx,nexty, n, m) && grid[nextx][nexty] == 1 && !visited[nextx][nexty]){
                              Point next = new Point(nextx,nexty,grid[nextx][nexty]);
                              stack.push(next);
                              visited[nextx][nexty] = true;
                              count++;
                          }
                      }
                  }
                  if(count>globalCount){
                      globalCount = count;
                  }
              }
          }  
        }
        return globalCount;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid,n,m));
    }
}
class Point{
    int x,y,value;
    Point(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
