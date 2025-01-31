int maxProfit(int[] W,int[] P,int C){

	helper(W,P,C,0);
}

int helper(int[] W,int[] P,int C,int index){
	if(C<=0 || index>=W.length) return 0;
	if(memo[index][C]!=null) return memo[index][C];
	int profit1=0;
	if(C>=W[index]){
		profit1=P[index]+helper(W,P,C-W[index],index);
	}
	int profit2=helper(W,P,C,index+1);
	return Math.max(profit1,profit2);
}

int maxProfit(int[] W,int[] P,int C){
	if(C<=0 || W.length==0 || W.length!=P.length) return 0;
	Integer memo[][]=new Integer[W.length][C+1];
        for(int i=0;i<P.length;++i){
		memo[i][0]=0;
	}
	for(int i=0;i<P.length;++i){
		for(int w=1;w<C+1;++w){
			int profit1=0;
			if(W[i]<=w){
				profit1=P[i]+memo[i][w-W[i]];
			}
			int profit2=0;
			if(i>0){
				profit2=memo[i-1][w];
			}
			memo[i][w]=Math.max(profit1,profit2);
		}
	}
	return memo[W.length-1][C];
}
