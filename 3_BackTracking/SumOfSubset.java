class Solution {
    int[] ans;
    public void SumOfSubset(int[] nums, int target) {
        ans=new int[nums.length];//000000
        int sum=0;
        for(int num:nums){
            sum=sum+num;
        }
        for(int i=0;i<nums.length;++i){
            DFS(sum,nums,i,target,0);            
        }
    }
    
    void DFS(int remainSum,int[] nums,int i,int target,int currSum){
        if(target==currSum){
            for(int z=0;z<ans.length;++z){
                System.out.print(ans[z]);
            }
            System.out.println("");
        }
        if(i==nums.length) return;
        if(remainSum<target-currSum) return;
        if(nums[i]+currSum<=target){
            ans[i]=1;
            DFS(remainSum-nums[i],nums,i+1,target,currSum+nums[i]);//selected
            ans[i]=0;
            DFS(remainSum,nums,i+1,target,currSum);//not selected
        }
    }
    
}