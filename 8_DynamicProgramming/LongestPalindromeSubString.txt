/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1 || s==null) return "";
        int left=0,right=0;
        for(int i=0;i<s.length();++i){
            int len1=lengthOfPalindromeExpandingFromCentreIndex(i,i,s);
            int len2=lengthOfPalindromeExpandingFromCentreIndex(i,i+1,s);
            int len=Math.max(len1,len2);
            if(right-left+1<len){
                left=i-(len-1)/2;
                right=i+len/2;
            }
        }
        return s.substring(left,right+1);
    }
    
    int lengthOfPalindromeExpandingFromCentreIndex(int center1,int center2,String s){
        if(center1>center2 || s==null) return 0;
        while(center1>=0 && center2<s.length() && s.charAt(center1)==s.charAt(center2)){
            --center1;
            ++center2;
        }
        return center2-center1-1;
    }
}
