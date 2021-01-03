//araaci       1
class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
      int count=0;
      int l=0;
      int winM=0;  
      HashMap<Character,Integer> map=new HashMap<>();
  
      for(int h=0;h<str.length();++h){
        Character curr=str.charAt(h);
        if(map.containsKey(curr)){
          map.put(curr,map.get(curr)+1);
        }
        else{
          ++count;
            map.put(curr,1);
          while(map.size()>k && l<str.length()){
            char temp=str.charAt(l);
            map.put(temp,map.getOrDefault(temp,0)-1);
            if(map.get(temp)<=0){
              map.remove(temp);
            }
            l++;
          }
        }
        winM=Math.max(winM,h-l+1);
      }
      return winM;
    }
  }