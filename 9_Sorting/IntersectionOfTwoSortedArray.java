class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1=0,ptr2=0;
        Set<Integer> intersection = new HashSet<>();
        while(ptr1<nums1.length && ptr2<nums2.length){
            if(nums1[ptr1]==nums2[ptr2]){
                intersection.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1]<nums2[ptr2]){
                ptr1++;
            }else{
                ptr2++;
            }
        }

        int K = intersection.size();
        int[] result=new int[K];
        int curr=0;
        for(int x:intersection){
            result[curr++]=x;
        }
        return result;
    }
}
