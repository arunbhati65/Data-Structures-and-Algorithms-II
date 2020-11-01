/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
*/
class Solution {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
    void helper(char[] s,int l,int h){
        if(l<h){
            char temp=s[l];
            s[l]=s[h];
            s[h]=temp;
            helper(s,++l,--h);
        }
    }
}