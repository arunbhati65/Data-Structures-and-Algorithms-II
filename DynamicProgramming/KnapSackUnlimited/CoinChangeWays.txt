/*
Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5', here are those ways:
  1. {1,1,1,1,1} 
  2. {1,1,1,2} 
  3. {1,2,2}
  4. {1,1,3}
  5. {2,3}
  */
public class CoinChangeWays {
    Integer[][] memo;
    int coinChangeWays(int[] coins,int total){
        memo=new Integer[coins.length][total+1];
        return helper(coins,total,coins.length-1);
    }

    int helper(int[] coins,int total,int index){
        if(total==0) return 1;
        if(index==-1 || total<0) return 0;
        if(memo[index][total]!=null) return memo[index][total];
        int ways=0;
        if(coins[index]<=total){
            ways=helper(coins,total-coins[index],index);
        }
        return memo[index][total]=ways+helper(coins,total,index-1);
    }
}
