class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
      int wSize=Integer.MAX_VALUE;
      int l=0;
      int sum=0;
      for(int h=0;h<arr.length;++h){
        sum=sum+arr[h];
        while(sum>=S){
            int winL=h-l+1;
            wSize=Math.min(wSize,winL);
            sum=sum-arr[l];
            l++;
        }
      }
      return wSize;
    }
  }