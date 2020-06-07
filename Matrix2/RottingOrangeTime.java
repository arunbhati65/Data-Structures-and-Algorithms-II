/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
*/
class Solution {
    Integer timeEach[][];
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return -1;
        timeEach=new Integer[grid.length][grid[0].length];
        initialize(grid);
        Helper(grid);
        return getTime(grid);
    }
    
    int getTime(int[][] grid){
        int time=0;
        for(int i=0;i<timeEach.length;++i){
            for(int j=0;j<timeEach[0].length;++j){
                if(grid[i][j]==1){
                    if(timeEach[i][j]==Integer.MAX_VALUE) {return -1;}
                    time=Math.max(time,timeEach[i][j]); 
                }
                
            }
        }
        return time;   
    }
    
    void initialize(int[][] grid){
         for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                timeEach[i][j]=(grid[i][j]==1)?Integer.MAX_VALUE:0;
            }
         }
    }
    
    void Helper(int [][] grid){
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==2){
                    DFS(i,j,grid,0);
                }
            }
        }
    }
    
    void DFS(int i,int j,int[][] grid,int level){
        if(timeEach[i][j]>level){timeEach[i][j]=level;}
        int[] x={1,-1,0,0};
        int[] y={0,0,-1,1};
        for(int m=0;m<x.length;++m){
            if(isValid(i+x[m],j+y[m],grid,level+1)){
                DFS(i+x[m],j+y[m],grid,level+1);
            }
        }
    }
    
    Boolean isValid(int i,int j,int[][] grid,int time){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1 && timeEach[i][j]>time;
    }
}