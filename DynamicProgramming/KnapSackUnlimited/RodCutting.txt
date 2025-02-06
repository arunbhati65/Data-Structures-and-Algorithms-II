int maxProfit(int[] L,int[] P,int length){
	helper(L,P,length,0);
}

int helper(int[] L,int[] P,int length,int index){
	if(length<=0 || index>=L.length) return 0;
	if(memo[index][length]!=null) return memo[index][length];
	int profit1=0;
	if(length>=L[index]){
		profit1=P[index]+helper(L,P,length-L[index],index);
	}
	int profit2=helper(L,P,length,index+1);
	return Math.max(profit1,profit2);
}
