//Given an input string, reverse the string word by word.
class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return "";
        s=reverse(s.toCharArray());
        int curr=0,start=0;
        StringBuilder sb=new StringBuilder();
        while(curr<s.length()){
            if(s.charAt(curr)!=' '){
                ++curr;
            }else{
                if(start!=curr){
                    sb.append(reverse(s.substring(start,curr).toCharArray())+" ");
                    start=curr;
                }else{
                    ++curr;
                    ++start;
                }
            }
        }
        if(start!=curr){
            sb.append(reverse(s.substring(start,curr).toCharArray())+" ");
        }
        return sb.length()==0?"":sb.toString().substring(0,sb.length()-1);
    }
    
    String reverse(char[] arr){
        int l=0,h=arr.length-1;
        while(l<h){
            char temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;--h;
        }
        return String.valueOf(arr);
    }
}