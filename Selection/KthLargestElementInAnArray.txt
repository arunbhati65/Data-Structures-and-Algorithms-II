class Solution {
    public int findKthLargest(int[] arr, int k) {
        if(arr.length==0) return 0;
        helper(arr,0,arr.length,k);
        return arr[k-1];
    }
    
    void helper(int[] arr,int l,int h,int k){
        if(l>h) return;
        int j=partition(arr,l,h,k);
        if(j==k-1) {
            return;
        }else if(j<k-1){
            helper(arr,j+1,h,k);
        }else{
            helper(arr,l,j,k);
        }
    }
    
    int partition(int[] arr,int l,int h,int k){
        int i=l,j=h,pivot=arr[l];
        while(i<j){
            do{
                ++i;
            }while(i<h && arr[i]>=pivot);
            do{
                --j;
            }while(j>=0 && arr[j]<pivot);
            if(i<j) swap(arr,i,j);
        }
        swap(arr,l,j);
        return j;
    }
    
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}