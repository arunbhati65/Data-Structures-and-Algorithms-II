class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSeqLen=0;
        int currSeqLength=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==1){
                ++currSeqLength;
            }else{
                maxSeqLen=Math.max(currSeqLength,maxSeqLen);
                currSeqLength=0;
            }
        }
        return maxSeqLen=Math.max(currSeqLength,maxSeqLen);
    }
}