/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
class Solution {
    public String minWindow(String txt, String pat) {
        int textLen=txt.length();
        int patLen=pat.length();
        int[] needToFind=new int[256];
        for(int i=0;i<patLen;++i){
            needToFind[pat.charAt(i)]++;
        }
        int[] hasFound=new int[256];
        int minWindLen=Integer.MAX_VALUE;
        int minWinBegin=0;
        int minWinEnd=0;
        int count=0;
        for(int begin=0,end=0;end<textLen;end++){  //Expansion
            if(needToFind[txt.charAt(end)]==0) continue;
            hasFound[txt.charAt(end)]++;
            if(hasFound[txt.charAt(end)]<=needToFind[txt.charAt(end)]){
                ++count;
            }
            if(count==patLen){
                while(needToFind[txt.charAt(begin)]==0 || 
                      hasFound[txt.charAt(begin)]>needToFind[txt.charAt(begin)]){
                    if(hasFound[txt.charAt(begin)]>needToFind[txt.charAt(begin)]){
                      hasFound[txt.charAt(begin)]--;  
                    }
                    begin++;//compresing
                }
                int windowLen = end - begin +1;
                if(windowLen<minWindLen){
                    minWinBegin=begin;
                    minWinEnd=end;
                    minWindLen=windowLen;
                }
            }
        }
        return  count==patLen?txt.substring(minWinBegin,minWinEnd+1):"";
    }
}