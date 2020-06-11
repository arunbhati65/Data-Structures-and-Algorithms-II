/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
*/
class Solution {  //Using Cumulative Sum Approcah i.e store sum of all the numbers --- o(n2)
    int count=0;
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int[] sum=new int[nums.length+1];
        sum[0]=0;
        for(int i=1;i<=nums.length;++i){
            sum[i]=sum[i-1]+nums[i-1];
        }
        for(int start=0;start<nums.length;++start){
            for(int end=start+1;end<=nums.length;end++){
                if(sum[end]-sum[start]==k){
                    count++;
                }
            }
        }
        return count;
    }
}