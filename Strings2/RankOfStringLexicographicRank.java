
	static int fact(int n){
     	if(n==1 || n==0) return 1; 
      	return n*fact(n-1);
    	}  
  
	// A function to find rank of a string in 
	// all permutations of characters 
	static int findRank(String str) 
	{ 	int rank=1;
     	int len=str.length();
     	int fact=fact(len);
     	int count[] =new int[256];
     	for(int i=0;i<256;i++){
           count[i]=0;
        }
     	for(int i=0;i<str.length();++i){
         	count[str.charAt(i)]++; 
        }
    	for(int i=1;i<256;++i){
         	count[i]=count[i]+count[i-1]; 
        }
     	for(int i=0;i<str.length();++i){
         	fact=fact/(len-i);
          	rank=rank+fact*count[str.charAt(i)-1];
          	for(int j=str.charAt(i);j<256;++j){
             	--count[j]; 
            }
        }     
     	return rank;
	} 