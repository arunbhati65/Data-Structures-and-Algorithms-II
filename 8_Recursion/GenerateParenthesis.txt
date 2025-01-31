class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        if(n==0) return ans;
        StringBuilder sb=new StringBuilder();
        helper(ans,n,0,"");
        return ans;
    }
    
    void helper(List<String> ans,int n,int openCount,String s){
        if(s.length()==n*2){
            ans.add(s);
            return;
        }
        if(openCount<n){
            helper(ans,n,openCount+1,s+"(");
        }
        int closeCount=s.length()-openCount;
        if(closeCount<openCount && closeCount<n){
            helper(ans,n,openCount,s+")");
        }
    }

}