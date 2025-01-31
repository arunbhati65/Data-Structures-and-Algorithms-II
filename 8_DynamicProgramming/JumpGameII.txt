class Solution {   //Jump Games2              
    public int jump(int[] nums) {
        int jump=0;
        int maxPos=0;
        int nextIndex=0;
        for(int i=0;i<nums.length-1;++i){
            maxPos=Math.max(maxPos,i+nums[i]);
            if(i==nextIndex){
                nextIndex=maxPos;
                ++jump;
            }
        }
        return jump;
    }
}

class Solution {//Not optimal
    Integer memo[];
    public int jump(int[] nums) {
        memo=new Integer[nums.length+1];
        return helper(nums,0);
    }
    int helper(int[] nums,int index){
        if(index>=nums.length) return nums.length+1;
        if(memo[index]!=null) return memo[index];
        if(index==nums.length-1) return 0;
        int ans=nums.length+1;
        for(int i=nums[index];i>=1;--i){
            ans=Math.min(ans,1+helper(nums,index+i));
        }
        return memo[index]=ans;
    }
}

