class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        Integer result[][]=new Integer[text1.length()+1][text2.length()+1];
       return helper(text1.toCharArray(),text2.toCharArray(),text1.length()-1,text2.length()-1,result) ;
    }
    
    int helper(char arr1[],char arr2[], int i1,int i2,Integer result[][]){
        if(i1<0 || i2<0){ return 0;}
        if(result[i1][i2]!=null) return result[i1][i2];
        else if(arr1[i1]==arr2[i2]){
           result[i1][i2]= 1+helper(arr1,arr2,i1-1,i2-1,result); 
        }else{
           result[i1][i2]= Math.max(helper(arr1,arr2,i1-1,i2,result),helper(arr1,arr2,i1,i2-1,result));
        }
        return result[i1][i2];
    }
}