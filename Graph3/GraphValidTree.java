/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
*/
class Solution {
    Boolean ans=true;
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph=new ArrayList[n];
        buildGraph(graph,edges);
        boolean[] visited=new boolean[n];
        DFS(graph,0,-1,visited);
        if(ans){
            for(int i=0;i<visited.length;++i){
                if(!visited[i]){
                    return false;
                }
            }
        }
        return ans;
    }
    
    void DFS(List<Integer>[] graph,int currentNode,int parentNode,boolean[] visited){
        visited[currentNode]=true;
        if(ans){
            for(int neighbour:graph[currentNode]){
                if(neighbour==parentNode) continue;
                else if(visited[neighbour]==false){
                    DFS(graph,neighbour,currentNode,visited);
                }else{//Cycle exist
                    ans=false;
                    return;
                }
            }            
        }

    }
    
    void buildGraph(List<Integer>[] graph,int[][] edges){
        for(int i=0;i<graph.length;++i){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }
}