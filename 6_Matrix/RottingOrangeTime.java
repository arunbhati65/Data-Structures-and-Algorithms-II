class Solution {
    public int orangesRotting(int[][] grid) {
        Integer[][] time=new Integer[grid.length][grid[0].length];
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==2){
                    time[i][j]=0;
                }else if(grid[i][j]==1){
                    time[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==2 && visited[i][j]==false){
                    visited[i][j]=true;
                    DFS(i,j,grid,visited,time,0);
                }
            }
        }
        int maxTime=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==3){
                    if(time[i][j]==null) return -1;
                    maxTime=Math.max(maxTime,time[i][j]);
                }else if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return maxTime;
    }
    
    boolean isSafe(int i,int j,boolean[][] visited,Integer[][] time,int t,int[][] grid){
        return i>=0 && i<visited.length && j>=0 && j<visited[0].length 
            && (time[i][j]!=null && t<time[i][j]) && visited[i][j]==false && (grid[i][j]==1||grid[i][j]==3);
    }
    void DFS(int i,int j,int[][] grid,boolean[][] visited,Integer[][] time,int t){
        time[i][j]=Math.min(t,time[i][j]);
        int[] x={1,-1,0,0};
        int[] y={0,0,1,-1};
        for(int m=0;m<x.length;++m){
            if(isSafe(i+x[m],j+y[m],visited,time,t+1,grid)){
                grid[i+x[m]][j+y[m]]=3;
                visited[i+x[m]][j+y[m]]= true;
                DFS(i+x[m],j+y[m],grid,visited,time,t+1);
                visited[i+x[m]][j+y[m]]= false;
            }
        }
    }
}