/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        if(haystack.length()<needle.length()) return -1;
        int q=101,d=256;
        //h=d^m-1/q
        int h=1;
        for(int i=0;i<needle.length()-1;++i){
            h=(h*d)%q;
        }
        //to and p calculation 
        int t=0,p=0;
        for(int i=0;i<needle.length();++i){
            p=(p*d+needle.charAt(i))%q;
            t=(t*d+haystack.charAt(i))%q;
        }
        
        //comparing t and p and on matching compare the internal characters
        for(int i=0;i<haystack.length()-needle.length()+1;++i){
            if(t==p){
                boolean flag=true;
                for(int j=0;j<needle.length();++j){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){flag=false;break;}
                }
                if(flag) return i;
            }
            if(i<haystack.length()-needle.length()){
                t=(haystack.charAt(i+needle.length())+d*(t-h*haystack.charAt(i)))%q;//calculating t(i+1)
                if(t<0) t=t+q;
            }
        }
        return -1;
    }
}