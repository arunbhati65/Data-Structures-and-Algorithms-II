class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int result[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=text1.length()-1;i>=0;--i){
            for(int j=text2.length()-1;j>=0;--j){
                if(text1.charAt(i)==text2.charAt(j)){
                    result[i][j]= 1+result[i+1][j+1];
                }else{
                    result[i][j]= Math.max(result[i+1][j],result[i][j+1]);
                }
            }
        }
        return result[0][0];
    }
}

class Solution {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo=new Integer[text1.length()][text2.length()];
        return helper(text1,text2,0,0);
    }
    
    int helper(String text1,String text2,int n,int m){
        if(n==text1.length()|| m==text2.length()) return 0;
        if(memo[n][m]!=null) return memo[n][m];
        if(text1.charAt(n)==text2.charAt(m)){
            return memo[n][m]=1+helper(text1,text2,n+1,m+1);
        }
        return memo[n][m]=Math.max(helper(text1,text2,n,m+1),helper(text1,text2,n+1,m));
    }
}

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