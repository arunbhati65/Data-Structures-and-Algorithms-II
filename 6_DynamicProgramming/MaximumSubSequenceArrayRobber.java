class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int A[]=new int[nums.length+1];
        A[0]=nums[0];
        if(nums.length==1) return A[nums.length-1];
        A[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;++i){
            A[i]=Math.max(nums[i]+A[i-2],A[i-1]);
        }
        return A[nums.length-1];
    }
}