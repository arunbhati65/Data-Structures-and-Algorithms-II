class Solution {
    int maxGlobal=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        helper(nums,nums.length-1);
        return maxGlobal;
    }

    int helper(int[] nums,int index){
      if(index==0) return maxGlobal=nums[0];
      int curMax=Integer.MIN_VALUE;
      curMax=Math.max(nums[index],nums[index]+helper(nums,index-1));
      maxGlobal=Math.max(maxGlobal,curMax);
      return curMax;
    }
}


class Solution {
    int maxGlobal=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
      int currMax=0;
      for(int i=0;i<nums.length;++i){
        currMax=currMax+nums[i];
        maxGlobal=Math.max(currMax,maxGlobal);
        if(currMax<0){
          currMax=0;
        }
      }
      return maxGlobal;
    }
}
