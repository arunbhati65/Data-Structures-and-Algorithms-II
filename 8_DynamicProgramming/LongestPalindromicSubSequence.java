/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
*/
class Solution {
    Integer memo[][];
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0) return 0;
        memo=new Integer[s.length()][s.length()];
        return helper(s,0,s.length()-1);
    }
    
    int helper(String s,int l,int h){
        if(l>h) return 0;
        if(memo[l][h]!=null) return memo[l][h];
        if(l==h) {
            return memo[l][h]=1;
        }
        if(s.charAt(l)==s.charAt(h)){
            return memo[l][h]=2+helper(s,l+1,h-1);
        }else{
            return memo[l][h]=Math.max(helper(s,l,h-1),helper(s,l+1,h));
        }
    }
}