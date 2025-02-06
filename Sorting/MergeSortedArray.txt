class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,ptr=nums1.length-1;
        while(i>=0 && j>=0){
            int temp;
            if(nums1[i]>nums2[j]){
                temp=nums1[i--];
            }else{
                temp=nums2[j--];
            }
            nums1[ptr--]=temp;
        }
        while(i>=0){
            int temp;
            temp=nums1[i--];
            nums1[ptr--]=temp;
        }
        while(j>=0){
            int temp;
            temp=nums2[j--];
            nums1[ptr--]=temp;
        }
    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=nums1.length-1;
        int m1=nums1.length;
        while(n>0){
            if(m==0 || nums1[m-1]<nums2[n-1]){
               nums1[index]=nums2[n-1];
               n--; 
            }else{
               nums1[index]=nums1[m-1]; 
               m--; 
            }
            index--;
        }
    }
}
