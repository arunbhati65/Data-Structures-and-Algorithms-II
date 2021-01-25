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

public static int findLength(String str) {
    int l=0;
    int winM=0;
    HashMap<Character,Integer> map=new HashMap<>();
    for(int h=0;h<str.length();++h){
      Character curr=str.charAt(h);
      if(!map.containsKey(curr)){
        map.put(curr,h);
        winM=Math.max(winM,h-l+1);
      }else{
        l=Math.max(l,map.get(curr)+1);
        map.put(curr,h);
        winM=Math.max(winM,h-l+1);
      }
    }
    return winM;
  }

  public static int findLength(char[] arr) {
    int max=0; 
    int l=0;
    HashMap<Character,Integer> map=new HashMap<>();
    for(int h=0;h<arr.length;++h){
       if(!map.containsKey(arr[h])){
           map.put(arr[h],h);
       }else{
           l=Math.max(l,map.get(arr[h]))+1;
           map.put(arr[h],h);
       }
       max=Math.max(max,h-l+1);
    }
    return max;
}
