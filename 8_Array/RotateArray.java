class Solution {
    //1 2 3 4 5 6   //2
    //6 5 4 3 2 1
    //5 6  1 2 3 4 
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    void reverse(int[] nums,int l,int h){
        int i=l,j=h;
        while(i<j){
            nums[i]=nums[i]^nums[j];
            nums[j]=nums[i]^nums[j];
            nums[i]=nums[i]^nums[j];
            ++i;
            j--;
        }
    }
}