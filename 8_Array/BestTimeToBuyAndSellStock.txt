/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE,maxProfit=0;
        for(int i=0;i<prices.length;++i){
            if(minPrice>prices[i]){
                minPrice=prices[i];
            }else if(maxProfit<prices[i]-minPrice){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}

class Solution {//Revision
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int lowest=0;
        int maxProfit=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;++i){
            if(prices[lowest]>prices[i]){
                lowest=i;
            }else{
                int profit=prices[i]-prices[lowest];
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        if(maxProfit==Integer.MIN_VALUE) return 0;
        return maxProfit;
    }
}