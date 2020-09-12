class Solution {
    Integer counter[]=null;
    public int climbStairs(int n) {
        counter=new Integer[n+1];
        return help(n);
    }
    
    public int help(int n){
        if(n<0)return 0;
        if(counter[n]!=null) return counter[n];
        if(n==0) return counter[n]=1;
        return counter[n]=(help(n-2)+help(n-1));
    }
}