class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] ans=new int[0][0];
        if(intervals.length==0) return ans;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return b[1]-a[1];
            }
        });
        
        pq.add(intervals[0]);
        for(int i=1;i<intervals.length;++i){
            if(pq.peek()[1]>=intervals[i][0]){
                int[] poll=pq.poll();
                if(poll[1]<intervals[i][1]){
                    poll[1]=intervals[i][1];
                }
                pq.add(poll);
            }else{
                pq.add(intervals[i]);
            }
        }
        ans=new int[pq.size()][2]; 
        int i=0;
        while(!pq.isEmpty()){
            ans[i]=pq.poll();
            ++i;
        }
        return ans;
    }
}