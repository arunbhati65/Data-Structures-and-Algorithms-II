/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
*/
class Solution {
    Boolean visited[][];
    int maxCount=0;
    int currCount=0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0) return 0;
        visited=new Boolean[grid.length][grid[0].length];
        islandHelper(grid);
        return maxCount;
    }
    
    void islandHelper(int[][] arr){
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr[0].length;++j){
                currCount=0;
                if(visited[i][j]==null && arr[i][j]==1){
                    DFS(i,j,arr);
                }
                maxCount=Math.max(maxCount,currCount);
            }
        }
    }
    
    void DFS(int i,int j,int[][] arr){
        visited[i][j]=true; ++currCount;
        int [] x={0,0,-1,1};
        int [] y={1,-1,0,0};
        for(int m=0;m<x.length;++m){
            if(isValid(i+x[m],j+y[m],arr)){
                DFS(i+x[m],j+y[m],arr);
            }
        }
    }
    
    Boolean isValid(int i,int j,int[][] arr){
        return (i>=0 && i<arr.length) && (j>=0 && j<arr[0].length) 
            && visited[i][j]==null && arr[i][j]==1;
    }
}