import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    int sDiff=Integer.MAX_VALUE;
    Arrays.sort(arr);
    for(int i=0;i<arr.length;++i){
      int l=i+1,h=arr.length-1;
      while(l<h){
        int cDiff=arr[i]+arr[l]+arr[h]-targetSum;
        if(Math.abs(cDiff)<Math.abs(sDiff)){
          sDiff=cDiff;
        }
        if(cDiff==0) return 0;
        if(cDiff>0){
          --h;
        }else{
          ++l;
        }
      }
    }
    return targetSum+sDiff;
  }
}