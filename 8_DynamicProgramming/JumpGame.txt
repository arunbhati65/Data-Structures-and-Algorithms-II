/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int lastGood=nums.length-1;
        for(int i=nums.length-1;i>=0;--i){
            if(i+nums[i]>=lastGood){
                lastGood=i;
            }    
        }
        return lastGood==0;
    }
}

class Solution {
    Boolean result[]=null;
    public boolean canJump(int[] nums) {
        result=new Boolean[nums.length+1];
        return helper(nums,0);
    }
    
    boolean helper(int[] nums,int i){
        if(i==nums.length-1) return true;
        if(result[i]!=null) return result[i];
        for(int j=1;j<=nums[i];++j){
            if(helper(nums,i+j)) return result[i]=true;
        }
        return result[i]=false;
    }
}

class Solution {
    boolean memo[];
    public boolean canJump(int[] nums) {
        memo=new boolean[nums.length];
        memo[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;--i){
            for(int j=1;j<=nums[i];++j){
                if(i+j<nums.length && memo[i+j]==true){
                    memo[i]=true;
                    break;
                }
            }
        }
        return memo[0];
    }
}

