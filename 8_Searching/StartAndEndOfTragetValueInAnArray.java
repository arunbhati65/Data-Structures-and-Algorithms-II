/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
*/
class StartAndEndOfTragetValueInAnArray {
    public int[] searchRange(int[] nums, int target) {
        int l=-1,h=-1;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==target){
                if(l==-1){
                    l=i;h=i;
                }else{
                    h=i;
                }
            }
            if(nums[i]!=target && l!=-1){
                break;
            }
        }
        int [] result={l,h};
        return result;
    }
}