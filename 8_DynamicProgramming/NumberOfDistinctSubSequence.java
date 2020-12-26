int numberOfDistinctSubSequqnce(String p,String t){
    int[][] memo=new int[p.length+1][t.length+1];
    for(int i=0;i<=t.length;++i){
        memo[0][i]=1;
    }
    for(int i=1;i<=p.length;++i){
        char pc=p.charAt(i-1);
        for(int j=1;j<=t.length;++j){
            char tc=t.charAt(j-1);
              if(tc==pc){
                    memo[i][j]=memo[i-1][j-1]+memo[i][j-1];	
            }else{
                memo[i][j]=memo[i][j-1];
            }
            
        }  
    }
    
    return memo[memo.length-1][memo[0].length-1];
}
