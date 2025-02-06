int platformCount(int[][] rail){
    Arrays.sort(rail,new Comparator<int[]>(){
    public int compare(int[] ob1,int[] ob2){
        return ob1[0]-ob2[0];
    }
     });
     PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
    public int compare(int[] ob1,int[] ob2){
        return ob1[1]-ob2[1];
    }	
     });
     pq.add(rail[0]);
     for(int i=1;i<rail.length;++i){
    if(pq.peek()[1]>rail[i][0]){
        pq.add(rail[i]);
    }else{
        int[] poll=pq.poll();
        pq.add(rail[i]);
    }
     }
     return pq.size();
} 