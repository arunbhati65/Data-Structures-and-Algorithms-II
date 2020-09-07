/*
Given an unsorted integer array, find the smallest missing positive integer.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int number=1;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==number){++number;}
            else if(nums[i]>number){
                break;
            }
        }
        return number;
    }
}