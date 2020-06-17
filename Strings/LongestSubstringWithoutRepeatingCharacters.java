//Given a string, find the length of the longest substring without repeating characters.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int N=s.length();
        int [] memo=new int[128];
        Arrays.fill(memo,-1);
        int maxLen=0;
        for(int j=0,i=0;j<N;++j){
            i=Math.max(i,memo[s.charAt(j)]+1);
            maxLen=Math.max(maxLen,j-i+1);
            memo[s.charAt(j)]=j;
        }
        return maxLen;
    }
}