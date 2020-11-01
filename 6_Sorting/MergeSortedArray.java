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