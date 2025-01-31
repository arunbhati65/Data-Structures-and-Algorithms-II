//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
class Solution {
    public int firstUniqChar(String s) {
        Integer[] count=new Integer[256];
        for(int i=0;i<s.length();++i){
            if(count[s.charAt(i)]==null){
                count[s.charAt(i)]=i;
            }else{
                count[s.charAt(i)]=-1;
            }
        }
        
        Integer res=Integer.MAX_VALUE;
        for(int i=0;i<256;++i){
            if(count[i]!=null && count[i]>=0){
                res=Math.min(res,count[i]);
            }
        }
        
        return res==Integer.MAX_VALUE?-1:res;
    }
}