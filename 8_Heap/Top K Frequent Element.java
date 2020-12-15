class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int[] ans=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((n1, n2) ->   map.get(n1)-map.get(n2));
        
        int i=0;
        while(i<=nums.length-1){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            i++;
        }
        for(Integer key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(i=0;i<k;++i){
            ans[i]=pq.poll();
        }
        return ans;
    }
}