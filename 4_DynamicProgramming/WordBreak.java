class Solution { //Faulty Code first attempt
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        wordDict.forEach(word->{
          set.add(word);  
        });
        int l=0,h=0;
        int lastFoundindex=-1;
        while(h<s.length()){
            String subString=s.substring(l,h+1);
            if(set.contains(subString)){
                lastFoundindex=h;
                l=h+1;
                ++h;
            }else{
                ++h;
            }
        }
        return lastFoundindex==s.length()-1;
    }
}

class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo=new Boolean[s.length()+1];
        return helper(new HashSet(wordDict),s,0);
    }
    
    boolean helper(Set<String> set,String s,int start){
        if(memo[start]!=null) return memo[start];
        if(start==s.length()) return true;
        for(int end=start;end<s.length();++end){
            if(set.contains(s.substring(start,end+1)) && helper(set,s,end+1)){
                return true;
            }
        }
        return memo[start]=false;
    }
}

class Solution {
    HashMap<String,Boolean> map=new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)) return map.get(s);
        if(s.length()==0){
            map.put(s,true);
            return true; 
        }
        Set<String> set=new HashSet(wordDict);
        for(int h=0;h<s.length();++h){
            if(set.contains(s.substring(0,h+1)) && wordBreak(s.substring(h+1,s.length()),wordDict)){
                map.put(s,true);
                return true;
            }            
        }
        map.put(s,false);
        return false;
    }
}
