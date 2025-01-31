/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
*/
class Solution {//Not Efficent
    
    public int minOperations(int[] arr, int x) {
        int moves=dfs(arr,x,0,arr.length-1);
        System.out.println(moves);
        return moves>arr.length?-1:moves;
    }
    
    int dfs(int[] arr,int target,int l,int h){
        if(target==0) return 0;
        if(l>h || l>arr.length-1 || h<0 || target<0)  return arr.length+1;
        return 1+Math.min(dfs(arr,target-arr[h],l,h-1),dfs(arr,target-arr[l],l+1,h));
    }
}

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=sum-x;
        int l=0,max=-1,sumW=0;
        for(int h=0;h<nums.length;++h){
            sumW+=nums[h];
            while(l<=h && sumW>target){
                sumW-=nums[l];
                ++l;
            }
            if(sumW==target){
                max=Math.max(max,h-l+1);
            }
        }
        if(max==-1) return -1;
        return nums.length-max;
    }
}