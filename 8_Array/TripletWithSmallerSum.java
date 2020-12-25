import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] arr, int target) {
    int count=0;
    Arrays.sort(arr);
    for(int i=0;i<arr.length;++i){
      int l=i+1,h=arr.length-1;
      while(l<h){
        int sum=arr[i]+arr[l]+arr[h];
        if(sum<target){
          count=count+h-l;
          l++;
        }
        else if(sum>=target){
          --h;
        }
      }
    }
    return count;
  }
}