/*
Given a 32-bit signed integer, reverse digits of an integer.
*/
class Solution {//improved
    public int reverse(int x) {
        boolean negative=x<0?true:false;
        x=Math.abs(x);
        int ans=0;
        while(x!=0){ //123
            int pop=x%10;
/*
However, this approach is dangerous, because the pop can cause overflow.
*/
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ans=ans*10+pop; //3
            x=x/10;//12
        }
        ans=negative?(ans*-1):ans;
        return ans;
    }
}

class ReverseNumber {
    public int reverse(int x) {
        boolean negative=x<0?true:false;
        x=Math.abs(x);
        String s=((Integer)x).toString();
        int len=s.length();
        s="";
        int rem=0;
        for(int i=1;i<=len;++i){
            rem=x%10;
            s=s+rem;
            x=x/10;
        }
        try{
          x=Integer.parseInt(s);  
        }catch(Exception ex){
            x=0;
        }
        
        x=negative?(x*-1):x;
        return x;
    }
}