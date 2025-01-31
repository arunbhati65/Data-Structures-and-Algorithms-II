class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0) return true;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int ob1[],int ob2[]){
                return ob1[0]-ob2[0];
            }
        });
         PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer ob1,Integer ob2){
                return ob1-ob2;
            } 
         });
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;++i){
            if(pq.peek()>intervals[i][0]) {return false;}
            else{
                pq.poll(); pq.add(intervals[i][1]);
            }
        }
        return true;
    }
}