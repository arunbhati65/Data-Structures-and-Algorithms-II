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