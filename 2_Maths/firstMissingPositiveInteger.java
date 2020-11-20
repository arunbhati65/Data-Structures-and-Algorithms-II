class Solution {//100
    public int firstMissingPositive(int[] nums) {
        boolean oneFound=false;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==1){
                oneFound=true;
            }else if(nums[i]>nums.length || nums[i]<=0){
                nums[i]=1;
            }
        }
        if(!oneFound) return 1;
        if(nums.length==1) return 2;
        for(int i=0;i<nums.length;++i){
            int index=Math.abs(nums[i])-1;
            nums[index]=nums[index]>0?-1*nums[index]:nums[index];
        }
        
        for(int i=0;i<nums.length;++i){
            if(nums[i]>0) return i+1;
        }
        
        return nums.length+1;
    }
}
