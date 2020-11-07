class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS[]=new int[nums.length];
        if(nums.length==0) return 0;
        LIS[0]=1;
        for(int i=1;i<nums.length;++i){
            LIS[i]=1;
            for(int j=0;j<i;++j){
                if(nums[j]<nums[i]){
                   LIS[i]=Math.max(LIS[i],LIS[j]+1); 
                }
            }
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<LIS.length;++i){
            result=Math.max(result,LIS[i]);
        }
        return result;
    }
}

class Solution {
    int[] LIS;
    public int lengthOfLIS(int[] nums) {
        LIS=new int[nums.length+1];
        for(int j=0;j<nums.length;++j){
            LIS[j]=1;
        }
        for(int i=1;i<nums.length;++i){
            helper(nums,i);
        }
        int lis=Integer.MIN_VALUE;
        for(int j=0;j<LIS.length;++j){
            lis=Math.max(lis,LIS[j]);
        }
        return lis;
    }
    
    void helper(int[] nums,int i){
        for(int j=0;j<i;++j){
           if(nums[i]>nums[j]){
               LIS[i]=Math.max(LIS[i],1+LIS[j]);
           } 
        }
    }
}