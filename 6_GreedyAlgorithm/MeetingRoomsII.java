/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int [] b){
                return a[0]-b[0];
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer  b){
                return intervals[a][1]-intervals[b][1];
            }            
        });
        pq.add(0);
        for(int i=1;i<intervals.length;++i){
            if(intervals[pq.peek()][1]<=intervals[i][0]){
                pq.poll();
            } 
            pq.add(i);
        }
        
        return pq.size();
    }
}
