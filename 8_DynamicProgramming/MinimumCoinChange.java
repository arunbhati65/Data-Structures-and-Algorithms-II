class Solution {
   
    public int coinChange(int[] coins, int amount) {
         Integer [] arr=new Integer[amount+1];
        int result=  helper(coins,amount,arr);
        if(result==Integer.MAX_VALUE) return -1;
        return result;
    }
    
    int helper(int[] coins,int amount,Integer [] arr){
        if (amount < 0) return -1;
        if(arr[amount]!=null) return arr[amount];
        if(amount==0) return arr[amount]=0; 
        arr[amount]= Integer.MAX_VALUE;
        for(int i=0;i<coins.length;++i){
            if(coins[i]>amount) continue;
            arr[amount]=Math.min(arr[amount],helper(coins,amount-coins[i],arr));
        }
        arr[amount]=(arr[amount]==Integer.MAX_VALUE)?arr[amount]:arr[amount]+1;
        return arr[amount];
    }
}