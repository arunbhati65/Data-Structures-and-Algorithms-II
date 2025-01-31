/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.
*/
class Solution {
    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] visitTime=new int[n];
        int[] lowTime=new int[n];
        boolean visited[]=new boolean[n];
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<graph.length;++i){
            graph[i]=new ArrayList<Integer>();
        }
        for(List<Integer> connection: connections){
            int a=connection.get(0),b=connection.get(1);
            graph[a].add(b); graph[b].add(a);
        }
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        DFS(graph,visited,0,-1,lowTime,visitTime,result);
        return result;            
    }
    
    void DFS(ArrayList<Integer>[] graph,boolean visited[],Integer currentNode,Integer parentNode
            ,int[] lowTime,int[] visitTime,List<List<Integer>> result){
        visited[currentNode]=true;
        visitTime[currentNode]=lowTime[currentNode]=time++;
        for(int nhbr:graph[currentNode]){
            if(nhbr==parentNode){continue;}
            else if(!visited[nhbr]){
                DFS(graph,visited,nhbr,currentNode,lowTime,visitTime,result);
                lowTime[currentNode]=Math.min(lowTime[currentNode],lowTime[nhbr]); 
                if(visitTime[currentNode]<lowTime[nhbr]){
                    result.add(Arrays.asList(currentNode,nhbr));
                }
            }else{
               lowTime[currentNode]=Math.min(lowTime[currentNode],lowTime[nhbr]); 
            }
        }
    }
        
}