class Solution {
    public void sortColors(int[] arr) {
        int l=0,m=0,h=arr.length-1;
        while(m<=h){
            if(arr[m]==0){
                swap(arr,l,m);
                l++;
                ++m;
            }else if(arr[m]==1){
                ++m;
            }else if(arr[m]==2){
                swap(arr,m,h);
                --h;
            }
        }
    }
    
    void swap(int[] arr,int m,int h){
        int temp=arr[m];
        arr[m]=arr[h];
        arr[h]=temp;
    }
}