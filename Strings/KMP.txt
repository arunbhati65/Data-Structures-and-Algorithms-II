//KMP Algorithm
class Solution {
    public int strStr(String txt, String pat) {
        int N=txt.length(),M=pat.length();
        if(N<M)return -1;
        if(M==0 || N==0) return 0;
        int [] LPS=new int[M];
        fillLPS(pat,LPS);
        int i=0,j=0;
        while(i<N){
            if(txt.charAt(i)==pat.charAt(j)){++i;++j;}
            if(j==M){return i-j;}
            else if(i<N && txt.charAt(i)!=pat.charAt(j)){
                if(j==0) {i++;}
                else{
                    j=LPS[j-1];
                }
            }
        }
        return -1;
    }
    
    void fillLPS(String str,int [] LPS){
        int i=1,j=0;
        LPS[0]=0;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(j)){++j; LPS[i]=j; ++i;}
            else{
                if(j==0) {LPS[i]=0;i++;}
                else{
                    j=LPS[j-1];
                }
            } 
        }
    }
}