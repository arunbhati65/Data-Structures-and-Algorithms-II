class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int ans=-1;
        int h;
        for(h=0;h<s.length();++h){
            char currChar=s.charAt(h);
            if(map.containsKey(currChar)){
                int oldIndex=map.get(currChar);
                if(oldIndex>=l){
                    ans=Math.max(ans,h-1-l+1);
                    l=oldIndex+1;
                }
            }
            map.put(currChar,h);
        }
        return Math.max(h-1-l+1,ans);
    }   
        
}
