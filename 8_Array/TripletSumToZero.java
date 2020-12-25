import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    Arrays.sort(arr);
    for(int i=0;i<arr.length;++i){
      int l=i+1,h=arr.length-1;
      while(l<h){
        int tSum=arr[i]+arr[l]+arr[h];
        if(tSum==0){
          List<Integer> list=new ArrayList<>();
          list.add(arr[i]);list.add(arr[l]);list.add(arr[h]);
          triplets.add(list);
          l++;h--;
        }else if(tSum>0){
          h--;
        }else{
          l++;
        }
      }
    }
    return triplets;
  }
}