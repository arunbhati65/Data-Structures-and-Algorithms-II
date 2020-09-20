class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> dict=new HashMap<>();
        for(char chr:t.toCharArray()){
            dict.put(chr,dict.getOrDefault(chr,0)+1);
        }
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        int matchCount=0;
        String ans="";
        int matchSubStringLength=Integer.MAX_VALUE;
        for(int h=0;h<s.length();++h){
            char currChar=s.charAt(h);
            map.put(currChar,map.getOrDefault(currChar,0)+1);
            if(dict.containsKey(currChar) && map.get(currChar)<=dict.get(currChar)){
                matchCount++;
            }

            while(matchCount==t.length()){
                if(matchCount==t.length() && (h-l+1)<matchSubStringLength){
                    ans=s.substring(l,h+1);
                    matchSubStringLength=ans.length();
                }
                char charAtL=s.charAt(l);
                if(map.containsKey(charAtL)){
                    if(dict.containsKey(charAtL) && map.get(charAtL)<=dict.get(charAtL)){
                        --matchCount;                        
                    }
                    map.put(charAtL,map.get(charAtL)-1);
                    if(map.get(charAtL)==0){
                        map.remove(charAtL);
                    }
                }
                ++l;
                while(l<s.length() && !dict.containsKey(s.charAt(l))  && l<h){
                    ++l;
                }
            }
        }
        
        return ans;
    }
}
