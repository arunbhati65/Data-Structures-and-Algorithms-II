/*
215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums,k,0,nums.length);
    }
    
    int helper(int[] nums, int k,int l,int h){
            int pivot=partition(nums,l,h);
            if(pivot==k-1){
                return nums[pivot];
            }
            else if(k-1<pivot){
                return helper(nums,k,l,pivot);
            }
            return helper(nums,k,pivot+1,h);
    }
    
    int partition(int[] nums,int l,int h){
        int pivot=nums[l];
        int i=l,j=h;
        while(i<j){
            do{
                ++i;
            }while(i<nums.length && nums[i]>=pivot);

            do{
               --j; 
            }while(nums[j]<pivot);
            if(i>j){
                break;
            }else{
                int temp1=nums[j];
                nums[j]=nums[i];
                nums[i]=temp1;
            }
        }
        int temp2=nums[j];
        nums[j]=pivot;
        nums[l]=temp2;  
        return j;
    }
}