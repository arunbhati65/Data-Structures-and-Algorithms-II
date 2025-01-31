class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>(k+1);
        for(int num:nums){
            add(num);
        }
    }
    public int add(int val) {
        pq.add(val); 
        if(pq.size()==k+1){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */