class Pair {
  int l = -1;
  int h = -1;
}

class Solution {
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0)
      return "";
    Pair resultIndex = new Pair();
    int charsToCount = t.length();
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int l = 0;
    for (int h = 0; h < s.length(); ++h) {
      if (charsToCount > 0) {
        if (map.containsKey(s.charAt(h))) {
          int countPending = map.get(s.charAt(h));
          map.put(s.charAt(h), map.get(s.charAt(h)) - 1);
          if (countPending > 0) {
            charsToCount--;
            // map.put(s.charAt(h),map.get(s.charAt(h))-1);
          }
        }
      }
      while (charsToCount == 0) {
        char cl = s.charAt(l);
        if (map.containsKey(cl)) {
          map.put(cl, map.get(cl) + 1);
          int countPending = map.get(cl);
          if (countPending > 0) {

            charsToCount++;
          }
        }
        if ((resultIndex.h == -1 && resultIndex.l == -1) || resultIndex.h - resultIndex.l > h - l) {
          resultIndex.h = h;
          resultIndex.l = l;
        }

        ++l;
      }
    }

    if (resultIndex.l == -1) {
      return "";
    }

    return s.substring(resultIndex.l, resultIndex.h + 1);
  }
}


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
        for(int begin=0,end=0;end<textLen;end++){
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
                    begin++;
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
