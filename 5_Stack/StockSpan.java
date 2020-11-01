	static void calculateSpan(int arr[], int n, int span[]) 
	{ 
	   span[0]=1;
       Stack<Integer> stack=new Stack<>();
      	stack.push(0);
       for(int i=1;i<arr.length;++i){
		 while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]){
         	stack.pop();
         }
         span[i]=stack.isEmpty()?(i-0+1):(i-stack.peek());
         stack.push(i);   
       }
	}