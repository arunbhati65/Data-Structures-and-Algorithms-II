class KthLargest {
    PriorityQueue<Integer> minPQ=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        if(nums.length==0) return;
        if(k<nums.length){
            partitionHelper(k,nums,0,nums.length);            
        }
        int index=Math.min(k,nums.length);
        for(int i=0;i<index;++i){
            minPQ.add(nums[i]);
        }
    }
    
    void partitionHelper(int k,int[] nums,int l,int h){
        if(l>h) return ;
        int j=partition(nums,l,h);
        if(j==k-1) return;
        if(j<k-1){
            partitionHelper(k,nums,j+1,h);
        }else{
            partitionHelper(k,nums,l,j);
        }
    }
    
    int partition(int[] nums,int l,int h){
        int i=l,j=h;
        while(i<j){
            do{
                ++i;
            }while(i<nums.length && nums[i]>=nums[l]);  
            do{
                --j;
            }while(nums[j]<nums[l]);
            if(i>j) break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    
    void swap(int[] nums,int l,int h){
        int temp=nums[l];
        nums[l]=nums[h];
        nums[h]=temp;
    }
    
    public int add(int val) {
        if(minPQ.size()<k){
           minPQ.add(val); 
        }
        else if(minPQ.peek()<val){
            minPQ.poll();
            minPQ.add(val);
        }
        return minPQ.peek();
    }
}
