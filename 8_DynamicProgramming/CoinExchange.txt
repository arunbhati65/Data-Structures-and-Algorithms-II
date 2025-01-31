class Solution {
  int maxCoins;
    public int coinChange(int[] coins, int amount) {
      Integer[][] memo=new Integer[amount+1][coins.length];
      int result=helper(coins,amount,0,memo);
      return result==Integer.MAX_VALUE?-1:result;
    }

    int helper(int[] coins,int amount,int index,Integer[][] memo){
      if(index>=coins.length || amount<0) return Integer.MAX_VALUE;
      if(amount==0) return 0;
      if(memo[amount][index]!=null) return memo[amount][index];
      int include=helper(coins,amount-coins[index],index,memo);
      if(include!=Integer.MAX_VALUE){
        include=include+1;
      }
      int exclude=helper(coins,amount,index+1,memo);
      return memo[amount][index]=Math.min(include,exclude);
    }
}

class Solution {
    Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        memo=new Integer[amount+1];
        return helper(coins,amount);
    }
    
    int helper(int coins[],int amount){
        if(amount<0)return -1;
        if(memo[amount]!=null) return memo[amount];
        if(amount==0)return memo[amount]=0;
        int coinCount=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;++i){
            if(coins[i]<=amount){
                int ahead=helper(coins,amount-coins[i]);
                if(ahead>=0 && ahead<coinCount){
                    coinCount=1+ahead;
                }
            }
        }
        if(coinCount==Integer.MAX_VALUE){
            return memo[amount]=-1;
        }
        return memo[amount]=coinCount;
    }
}


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] memo=new int[amount+1];
        memo[0]=0;
        for(int i=1;i<memo.length;++i){
            memo[i]=amount+1;
        }
        for(int i=0;i<=amount;++i){//amount 5
            for(int j=0;j<coins.length;++j){//coins 2
                if(i>=coins[j]){
                    memo[i]=Math.min(memo[i],1+memo[i-coins[j]]);                    
                }
            }
        }
        return memo[amount]>amount?-1:memo[amount];
    }
}

