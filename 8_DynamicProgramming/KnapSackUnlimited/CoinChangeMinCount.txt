public class CoinChangeMinCount {
    Integer[][] memo;
    Integer max;
    int minCoinChangeCount(int[] coins,int total){
        memo=new Integer[coins.length][total+1];
        max=total+1;
        int ans=helper(coins,total,coins.length-1);
        if(ans>=max) return -1;
        return ans;
    }

    int helper(int[] coins,int total,int index){
        if(total==0) return 0;
        if(index==-1 || total<0) return max;
        if(memo[index][total]!=null) return memo[index][total];
        int count1=max;
        if(coins[index]<=total){
            int local=1+helper(coins,total-coins[index],index);
            count1=Math.min(count1,local);
        }
        int count2=helper(coins,total,index-1);
        return memo[index][total]=Math.min(count1,count2);
    }
}