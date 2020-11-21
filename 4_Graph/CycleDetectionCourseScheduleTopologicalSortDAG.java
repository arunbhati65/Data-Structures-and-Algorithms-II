/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
finish all courses?
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] courses) {
        Integer[] inDegree=new Integer[numCourses];
        for(int i=0;i<numCourses;++i){
            inDegree[i]=0;
        }
        List<List<Integer>> graph=new LinkedList<>();
        for(int i=0;i<numCourses;++i){
            graph.add(new LinkedList<Integer>());
        }
        for(int i=0;i<courses.length;++i){
            graph.get(courses[i][1]).add(courses[i][0]);
            inDegree[courses[i][0]]++;
        }
        Boolean visited[]=new Boolean[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<inDegree.length;++i){
            if(inDegree[i]==0){
                queue.add(i);
                visited[i]=true;
            }
        }
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int i=0;i<graph.get(curr).size();++i){
                int j=graph.get(curr).get(i);
                if(visited[j]==null){
                    --inDegree[j];
                    if(inDegree[j]==0){
                        queue.add(j);
                        visited[j]=true;
                    }
                }
            }
        }
        for(int i=0;i<inDegree.length;++i){
            if(inDegree[i]!=0) return false;
        }
        return true;
    }
}