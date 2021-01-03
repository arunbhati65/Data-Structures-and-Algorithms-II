/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
Follow up:
Could you solve it in linear time?
Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
class Solution {
    //0 1 2// 3 4 5
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<k;++i){
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[0]=nums[dq.getFirst()];
        for(int i=k;i<nums.length;++i){
            int firstDQ=dq.getFirst();
            while(!dq.isEmpty() && firstDQ<= i-k){
                dq.removeFirst();
                firstDQ=dq.isEmpty()?-1:dq.getFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            ans[i-k+1]=nums[dq.getFirst()];
        }
        return ans;
    }
}