/*
Search in Rotated Sorted Array*/
class AlteredBinarySearchPivot { //binary Search Altered
    public int search(int[] arr, int target) {
       return srch(arr,0,arr.length-1,target);
    }
    
    int srch(int[] arr,int l,int h,int target){ // trick: find the sorted half and check if target in it
                                                // if not in sorted half go to unsorted half
        if(h<l){return -1;}
        int mid=(l+h)/2;
        if(arr[mid]==target) return mid;
        if(arr[mid]>=arr[l]){ //is first half sorted
            if(target>=arr[l] && target<=arr[mid]){   //is in first half             
                return srch(arr,l,mid-1,target);
            }else{
                return srch(arr,mid+1,h,target); //in secound half
            }   
        }else{//2nd half sorted
            if(target>=arr[mid] && target<=arr[h]){//in secound half
                return srch(arr,mid+1,h,target);
            } else{ // in first half
                return srch(arr,l,mid-1,target);
            }

        }       
    } 
}