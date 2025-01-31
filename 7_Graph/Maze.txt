class Solution {
    boolean isSafe(int[] v,int[][] maze){
        return v[0]>=0 && v[0]<maze.length && 
            v[1]>=0 && v[1]<maze[0].length && maze[v[0]][v[1]]==0;
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        q.add(start);
        int[] x={0,0,1,-1};
        int[] y={1,-1,0,0};
        while(!q.isEmpty()){
            int[] u=q.poll();
            visited[u[0]][u[1]]=true;
            if(destination[0]==u[0]&&destination[1]==u[1]){
                boolean isBlocked=false;
                for(int i=0;i<x.length;++i){
                    int[] m=new int[]{u[0]+x[i],u[1]+y[i]};
                    if(isSafe(m,maze)){
                        if(visited[m[0]][m[1]]==false){
                            return false;
                        }
                    }
                }
                return true;
            }
            for(int i=0;i<x.length;++i){
                int[] v=new int[]{u[0]+x[i],u[1]+y[i]};
                if(isSafe(v,maze) && visited[v[0]][v[1]]!=true){
                    q.add(v);
                }
            }
        }
        return false;
    }
}