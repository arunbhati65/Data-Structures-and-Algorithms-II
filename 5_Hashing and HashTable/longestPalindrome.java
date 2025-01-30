class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();++i){
          map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean oddpresent=false;
        int size=0;
        for(int val:map.values()){
          if(val%2==0){
            size=size+val;
          }else{
            size=size+val-val%2;
            oddpresent=true;
          }
        }
        if(oddpresent){
          size++;
        }
        return size;
    }
}
