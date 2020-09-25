/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
*/
class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        return helper(x,0,x);
    }
    
    int helper(int x,int l,int h){
        if(l>h) return -1;
        if(l+1==h) return l;
        long avg=l+(h-l)/2;
        long mul=avg*avg;
        if(mul==x){
          return (int)avg;  
        }else if(mul<x){
            return helper(x,(int)avg,h);
        } return helper(x,l,(int)avg);
        
    }
}

class Solution {
    public int mySqrt(int x) {
        if(x<=1) return x;
        int left=2,right=x/2;
        while(left<=right){
            int pivot=(left+right)/2;
            if((long)pivot*pivot>x) {right=pivot-1;}
            else if((long)pivot*pivot<x) {left=pivot+1;}
            else return pivot;
        }
        return right;
    }
}
