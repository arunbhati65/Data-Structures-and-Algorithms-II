/*
You are given an integer n. An array nums of length n + 1 is generated in the following way:

nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums​​​.
*/
class Solution {
    public int getMaximumGenerated(int n) {
        if(n<=0) return 0;
        int[] memo=new int[n+1];
        memo[0]=0;
        memo[1]=1;
        int max=1;
        for(int i=2;i<memo.length;++i){
            if(i%2==0){
                memo[i]=memo[i/2];
            }else{
                memo[i]=memo[i/2]+memo[i/2+1];
            }
            max=Math.max(max,memo[i]);
        }
        return max;
    }
}