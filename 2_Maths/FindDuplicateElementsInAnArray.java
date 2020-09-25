class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;++i){
            int abs=Math.abs(nums[i]);
            if(nums[abs]<0){
                return abs;
            }
            nums[abs]=-1*nums[abs];
        }
        return -1;
    }
}
