/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water
*/
class Solution {
    Boolean visited[][];
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        visited=new Boolean[grid.length][grid[0].length];
        return countHelper(grid);
    }
    
    int countHelper(char[][] arr){
        int count=0;
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr[0].length;++j){
                if(visited[i][j]==null && arr[i][j]=='1'){
                    DFS(i,j,arr);
                    count++;
                }

            }
        }
        return count;
    }
    
    void DFS(int i,int j,char[][] arr){
        visited[i][j]=true;
        int [] x={-1,1,0,0};
        int [] y={0,0,-1,1};
        for(int m=0;m<x.length;++m){
            if(isSafe(i+x[m],j+y[m],arr)){
                DFS(i+x[m],j+y[m],arr);
            }
        }
    }
    
    boolean isSafe(int i,int j,char[][] arr){
        return (i>=0 && i<arr.length)&&(j>=0 && j<arr[0].length)&&visited[i][j]==null && arr[i][j]=='1';
    }
    
}