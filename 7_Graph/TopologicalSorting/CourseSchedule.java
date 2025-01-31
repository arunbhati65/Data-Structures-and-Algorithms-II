class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;++i){
          graph.add(new ArrayList<Integer>());
        }
        int[] indegree=new int[numCourses];
        for(int[] vertex:prerequisites){
          graph.get(vertex[1]).add(vertex[0]);
          indegree[vertex[0]]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;++i){
         // indegree[i]=graph.get(i).size();
          if(indegree[i]==0){
            q.add(i);
          }
        }
        while(!q.isEmpty()){
          int u=q.poll();
          for(int v:graph.get(u)){
            indegree[v]--;
            if(indegree[v]==0){
              q.add(v);
            }
          }
        }
        for(int i=0;i<numCourses;++i){
          if(indegree[i]>0){
            return false;
          }
        }
        return true;
    }
}
