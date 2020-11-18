class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited=new boolean[graph.length];
        LinkedList<Integer> s=new LinkedList<>();
        s.add(0);
        DFS(graph,0,s,visited);
        return ans;
    }
    
    void DFS(int[][] graph,int u,LinkedList<Integer> s,boolean[] visited){
        visited[u]=true;
        if(u==graph.length-1){
            ans.add(new ArrayList<Integer>(s));
            visited[u]=false;
            return;
        }
        for(int v:graph[u]){
            if(visited[v]==false){
                s.add(v);
                DFS(graph,v,s,visited);
                s.remove(s.size()-1);
            }
        }
        visited[u]=false;
    }
    
}