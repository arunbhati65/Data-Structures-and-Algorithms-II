class Solution {
    List<List<Integer>> paths=new ArrayList<>();
    boolean visited[] ;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph.length==0) return paths;
        visited =new boolean[graph.length];
        int src=0;
        int des=graph.length-1;
        List<Integer> path=new ArrayList<>();
        path.add(src);
        DFS(src,des,graph,path);
        return paths;
    }
    
    void DFS(int currNode,int des,int[][] graph,List<Integer> path){
        visited[currNode]=true;
        if(des==currNode){
            paths.add(new ArrayList<>(path));
        }else{
            for(int neighbour:graph[currNode]){
                if(visited[neighbour]==false){
                    path.add(neighbour);
                    DFS(neighbour,des,graph,path);
                    path.remove(path.size()-1);
                }
            }
        }
        visited[currNode]=false;
    }
}