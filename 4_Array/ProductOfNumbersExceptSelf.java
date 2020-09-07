/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i].
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=1;
        for(int i=1;i<left.length;++i){
            left[i]=nums[i-1]*left[i-1];
        }
        right[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;--i){
            right[i]=nums[i+1]*right[i+1];
        }
        for(int i=0;i<nums.length;++i){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}