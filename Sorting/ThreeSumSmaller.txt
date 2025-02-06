class Solution {
    int ans=0;
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;++i){
            twoSum(nums,target-nums[i],i+1,nums.length-1);
        }
        return ans;
    }
    
    void twoSum(int[] nums,int target,int l,int h){
        while(l<h){
            if(nums[l]+nums[h]>=target){
                --h;
            }else{
                ans=ans+h-l;
                ++l;
            }
        }
    }
}