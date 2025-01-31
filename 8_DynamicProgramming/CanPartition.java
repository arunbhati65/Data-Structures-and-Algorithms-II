class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
          sum=sum+num;
        }
        if(sum%2!=0) return false;
        Boolean[][] memo=new Boolean[sum/2+1][nums.length];
        return subSequenceSum(nums,sum/2,0,memo);
    }

    boolean subSequenceSum(int[] nums,int sum,int index,Boolean[][] memo){
      if(sum<0) return false;
      if(sum==0) return true;
      if(index>=nums.length) return false;
      if(memo[sum][index]!=null) return memo[sum][index];
      boolean include=subSequenceSum(nums,sum-nums[index],index+1,memo);
      boolean exclude=subSequenceSum(nums,sum,index+1,memo);
      return memo[sum][index] = (include || exclude);
    }
}
