h
int findCountOfElement(int[] arr,int target){
    if(arr.length==0)return -1;
    int left=getRange(arr,0,arr.length-1,false,target);
    if(left==-1) return -1;
    int right=getRange(arr,0,arr.length-1,true,target);
    return right-left+1;
} 
int getRange(int[] arr,int l,int h,boolean isLeft,int target){
    int range=-1;
    while(l<=h){
        int mid=l+(h-l)/2;
        if(arr[mid]==target){
            range=mid;
            if(!isLeft){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        else if(arr[mid]>target){
            h=mid-1;
        }else{
            l=mid+1;
        }
    }
    
    return range;
}