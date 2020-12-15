class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        if(nums.length==0) return ans;
        for(int num:nums){
            if(nums[Math.abs(num)-1]<0){
                ans.add(Math.abs(num));
            }else{
                nums[Math.abs(num)-1]=-nums[Math.abs(num)-1];
            }
        }
        return ans;
    }
}