//Max Number of K-Sum Pairs
class Solution {
    public int maxOperations(int[] arr, int k) {
        Arrays.sort(arr);
        int l=0,h=arr.length-1;
        int count=0;
        while(l<h){
            int sum=arr[l]+arr[h];
            if(sum==k){
                ++count;
                ++l;
                --h;
            }else if(sum>k){
                --h;
            }else{
                ++l;
            }
        }
        return count;
    }
}