/*
215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums,k,0,nums.length);
    }
    
    int helper(int[] nums,int k,int l,int h){
        if(l>h) return -1;
        int j=partition(nums,l,h);
        if(j==nums.length-k) {
            return nums[j];
        }    
        else if(j>nums.length-k){
            return helper(nums,k,l,j);
        }
            return helper(nums,k,j+1,h);
        
    }
    
    int partition(int[] nums,int l,int h){
        int pivot=l;
        int i=l,j=h;
        while(i<h){
            do{
               ++i; 
            }while(i<nums.length && nums[i]<=nums[pivot]);
            do{
               --j; 
            }while(j>=0 && nums[j]>nums[pivot]);
            if(i<j){
                int temp1=nums[i];
                nums[i]=nums[j];
                nums[j]=temp1;               
            }else{
                break;
            }

        }
        int temp2=nums[pivot];
        nums[pivot]=nums[j];
        nums[j]=temp2;
        return j;
    }
}

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