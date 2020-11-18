class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        s.push(0);
        DFS(graph,0,s,visited);
        return ans;
    }
    
    void DFS(int[][] graph,int u,Stack<Integer> s,boolean[] visited){
        visited[u]=true;
        if(u==graph.length-1){
            List<Integer> list=new ArrayList<>();
            printStack(s,list);
            visited[u]=false;
            return;
        }
        for(int v:graph[u]){
            if(visited[v]==false){
                s.push(v);
                DFS(graph,v,s,visited);
                s.pop();
            }
        }
        visited[u]=false;
    }
    
    void printStack(Stack<Integer> s,List<Integer> list){
        if(s.isEmpty()){
            ans.add(list);
            return;
        }
        int top=s.pop();
        list.add(0,top);
        printStack(s,list);
        s.push(top);
    }
}