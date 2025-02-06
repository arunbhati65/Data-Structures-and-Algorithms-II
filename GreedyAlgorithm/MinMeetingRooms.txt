class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
           public int compare(Integer o1,Integer o2){
               return o1-o2; 
           }
        });
        Arrays.sort(intervals,new Comparator<int[]>(){
           public int compare(int[] o1,int[] o2){
               return o1[0]-o2[0]; 
           }
        });
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;++i){
            if(pq.peek()<=intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}