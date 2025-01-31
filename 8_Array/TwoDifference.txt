public class TwoDifference {
    int count=0;
    int countDiffPair(int[] arr,int target){
        if(arr.length==0) return 0;
        for(int i=0;i<arr.length;++i){
            binarySearch(i,arr,target-arr[i],true);
            binarySearch(i,arr,target-arr[i],false);
            if(target-arr[i]==0) continue;
            binarySearch(i,arr,arr[i]-target,true);
            binarySearch(i,arr,arr[i]-target,false);
        }
        return count;
    }

    void binarySearch(int l,int[] arr,int key,boolean leftSearch){
        int h=arr.length-1;
        while(l<h){
            int mid=l+(h-l)/2;
            if(arr[mid]==key){
                ++count;
                if(leftSearch){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }else if(arr[mid]>key){
                --l;
            }else{
                ++h;
            }
        }
    }
}
