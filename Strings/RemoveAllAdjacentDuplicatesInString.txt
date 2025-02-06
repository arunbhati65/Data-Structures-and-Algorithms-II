/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
*/
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb=new StringBuilder();
        for(char character:s.toCharArray()){
            if(sb.length()!=0 && character==sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(character);
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb=new StringBuilder();
        int index=-1,i=0;
        while(i<s.length()){
            if(index!=-1 && s.charAt(i)==sb.charAt(index)){
                sb.deleteCharAt(index);
                --index;
            }else{
                sb.append(s.charAt(i));
                ++index;
            }
            ++i;
        }
        return sb.toString();
    }
}

class Solution {
    public String removeDuplicates(String S) {
         char [] chars=S.toCharArray();
         for(int i=1;i<chars.length;++i){
             int prevIndexToCheck=getPrevIndex(chars,i);
             if(chars[prevIndexToCheck]==chars[i]){
                 chars[prevIndexToCheck]=chars[i]='#';
             }
         }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;++i){
            if(chars[i]!='#'){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    
    int getPrevIndex(char[] chars,int currIndex){
        int i=currIndex-1;
        while(i>=0 && chars[i]=='#'){
            --i;            
        }
        return i<0?0:i;
    }
    
}
