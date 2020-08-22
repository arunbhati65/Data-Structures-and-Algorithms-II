/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

import java.util.Arrays;
class TwoSum{
    public int[] twoSumUsingSorting(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int l=0,h=nums.length-1,currSum;
        while(l<h){
            currSum=nums[l]+nums[h];
            if(currSum==target){
                break;
            }
            if(currSum>target) --h;
            else ++l;
        }
        int [] result={map.get(nums[l]),map.get(nums[h])};
        return result;
    }

    public static int[] twoSumUsingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

class Solution {//Revision
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int [] result=new int[2];
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
}