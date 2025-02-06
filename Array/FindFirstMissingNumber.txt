/*
Given an unsorted integer array, find the smallest missing positive integer.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int number=1;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==number){++number;}
            else if(nums[i]>number){
                break;
            }
        }
        return number;
    }
}

class Solution {
    public int solution(int[] A) {
        for(int i=0;i<A.length;++i){
            if(A[i]<0){
                A[i]=0;
            }
        }
        for(int i=0;i<A.length;++i){
            if(A[i]==0 || A[Math.abs(A[i])-1]<0) continue;
            A[Math.abs(A[i])-1]=-1*A[Math.abs(A[i])-1];
        }
       
        int i=0;
        for(i=0;i<A.length;++i){
            if(A[i]>=0) return i+1;
        }
        return i+1;
    }
}