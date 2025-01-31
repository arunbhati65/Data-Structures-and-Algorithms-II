class Solution {
    Integer[] ways;
    public int climbStairs(int n) {
        ways=new Integer[n+1];
        ways[0]=0;
        if(n<3) return n;
        ways[1]=1;
        ways[2]=2;
        for(int i=3;i<=n;++i){
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n];
    }
}

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
