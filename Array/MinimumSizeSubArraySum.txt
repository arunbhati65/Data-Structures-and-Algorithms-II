class Solution {
    //minimum number of people required for meeting the criteria
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
        int minLengthRequired=Integer.MAX_VALUE;
        int currSumInWindow=0;
        int l=0;
        for(int h=0;h<nums.length;++h){//expansion
            currSumInWindow=currSumInWindow+nums[h];
            while(currSumInWindow>=s){//contraction
                minLengthRequired=Math.min(h-l+1,minLengthRequired);
                currSumInWindow=currSumInWindow-nums[l];
                l++;
            }
        }
        if(minLengthRequired==Integer.MAX_VALUE){
            return 0;
        }
        return minLengthRequired;
        
    }
}