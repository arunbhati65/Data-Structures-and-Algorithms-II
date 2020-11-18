class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0) return -1;
        if(grid[0][0]==1) return-1;
        return hasPath(grid,new int[]{0,0},new int[]{grid.length-1,grid[0].length-1},0);
    }
    boolean isSafe(int[] v,int[][] maze){
        return v[0]>=0 && v[0]<maze.length && 
            v[1]>=0 && v[1]<maze[0].length && maze[v[0]][v[1]]==0;
    }
    
    public int hasPath(int[][] maze, int[] start, int[] destination,int level) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        q.add(start);
        int[] x={0,0,1,-1,1,-1,1,-1};
        int[] y={1,-1,0,0,1,-1,-1,1};
        while(!q.isEmpty()){
            int size=q.size();
            ++level;
            for(int m=0;m<size;++m){
                int[] u=q.poll();
                visited[u[0]][u[1]]=true;
                if(destination[0]==u[0]&&destination[1]==u[1]){
                    return level;
                }
                for(int i=0;i<x.length;++i){
                    int[] v=new int[]{u[0]+x[i],u[1]+y[i]};
                    if(isSafe(v,maze) && visited[v[0]][v[1]]!=true){
                        q.add(v);
                    }
                }                
            }
        }
        return -1;
    }
}

