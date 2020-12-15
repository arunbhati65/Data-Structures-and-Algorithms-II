class Solution {
    int minDiff=Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;++i){
            twoSum(nums,target,i,i+1,nums.length-1);
            if(minDiff==0) break;
        }
        return target-minDiff;
    }
    
    void twoSum(int[] nums,int target,int i,int l,int h){
        while(l<h){
            int sum=nums[i]+nums[l]+nums[h];
            if(Math.abs(target-sum)<Math.abs(minDiff)){
                minDiff=target-sum;
            }
            if(sum>target){
                --h;
            }else if(sum<target){
                ++l;
            }else{
                return;
            }
        }
    }
}