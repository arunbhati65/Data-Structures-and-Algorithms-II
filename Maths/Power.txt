class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-1*N;
        }
        return myPowL(x,N);
    }
    
    public double myPowL(double x, long N) {
        if(N==0) return 1;
        double pow=myPowL(x,N/2);
        if(N%2==0){
            return pow*pow;
        }
        return pow*pow*x;
    }
}