class Solution {
    Integer[][] arr;
    public int minDistance(String word1, String word2) {
        arr=new Integer[word1.length()+1][word2.length()+1];
        return helper(word1,word1.length(),word2,word2.length());
    }
    
    
    int helper(String word1,int i1,String word2,int i2){
        if(arr[i1][i2]!=null) return arr[i1][i2];
        if(i1==0) return arr[i1][i2]=i2;
        if(i2==0) return arr[i1][i2]=i1;
        if(word1.charAt(i1-1)==word2.charAt(i2-1)){
            return arr[i1][i2]=helper(word1,i1-1,word2,i2-1);
        }else{
            return arr[i1][i2]=1+ Math.min(helper(word1,i1,word2,i2-1), //insetion
                    Math.min(helper(word1,i1-1,word2,i2), //deletion
                             helper(word1,i1-1,word2,i2-1))); //replace
        }
    }
}