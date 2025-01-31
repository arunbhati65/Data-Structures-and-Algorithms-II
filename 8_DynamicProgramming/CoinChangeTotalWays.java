class Solution {
    public int change(int amount, int[] coins) {
      Integer[][] memo=new Integer[amount+1][coins.length];
      return helper(coins,amount,0,memo);
    }

    int helper(int[] coins,int amount,int index,Integer[][] memo){
      if(index>=coins.length || amount<0) return 0;
      if(amount==0) return 1;
      if(memo[amount][index]!=null) return memo[amount][index];
      int ways=helper(coins,amount-coins[index],index,memo);
      ways=ways+helper(coins,amount,index+1,memo);
      return memo[amount][index]=ways;
    }
}
