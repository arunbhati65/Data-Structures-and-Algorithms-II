class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        if (k == nums.length) {
            return ans=nums;
        }
        HashMap<Integer,Integer> countMap=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        nums=new int[countMap.keySet().size()];
        int m=0;
        for(Integer key:countMap.keySet()){
            nums[m]=key;
            ++m;
        }
        int j=helper(nums,k,0,nums.length,countMap);
        for(int i=0;i<ans.length;++i){
            ans[i]=nums[i];
        }
        return ans;
    }
    
    int helper(int[] nums,int k,int l,int h,Map<Integer,Integer> map){
        if(l>h) return -1;
        int j=partition(nums,l,h,map);
        if(j==k-1){
            return j;
        }else if(j>k-1){
            return helper(nums,k,l,j,map);
        }
        return helper(nums,k,j+1,h,map);
    }
    
    int partition(int[] nums,int l,int h,Map<Integer,Integer> map){
        int pivot=l,i=l,j=h;
        while(i<j){
            do{
                ++i;
            }while(i<nums.length && map.get(nums[i])>=map.get(nums[pivot]));
            do{
                --j;
            }while(j>=0 && map.get(nums[j])<map.get(nums[pivot]));
            if(i>j) break;
            int temp1=nums[i];
            nums[i]=nums[j];
            nums[j]=temp1;
        }
        int temp2=nums[pivot];
        nums[pivot]=nums[j];
        nums[j]=temp2;
        return j;
    }
}