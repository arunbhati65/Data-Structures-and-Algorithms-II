/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
*/
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