class Knapsack { 
	static int helper(int val[],int wt[],int weight,int i){
      	if(i<0) return 0;
        if(wt[i]>weight ) return 0;
      	return Math.max(helper(val,wt,weight,i-1),val[i]+helper(val,wt,weight-wt[i],i-1));
      	
    }  


	public static void main(String args[]) 
	{ 
		int val[] = new int[] { 60, 100, 120 }; 
		int wt[] = new int[] { 10, 20, 30 }; 
		int W = 50; 
		int n = val.length; 
		System.out.println(helper(val,wt,W,n-1));
	} 
} 