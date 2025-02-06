class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
      int wSize=Integer.MAX_VALUE;
      int l=0;
      int sum=0;
      for(int h=0;h<arr.length;++h){
        sum=sum+arr[h];
        int winL=h-l+1;
        if(sum==S){
          wSize=Math.min(wSize,winL);
          sum=sum-arr[l];
          l++;
        }else if(sum>S){
          while(sum>S){
            sum=sum-arr[l];
            l++;
          }
          if(sum==S){
            winL=h-l+1;
            wSize=Math.min(wSize,winL);
            sum=sum-arr[l];
            l++;
          }
        }
      }
      return wSize;
    }