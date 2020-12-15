/*
You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
*/    
static int minimumSwaps(int[] arr) {
        int count=0;
        boolean [] visited=new boolean[arr.length+1]; 
        for(int i=0;i<arr.length;++i){
            if(visited[i+1]==false){
               visited[i+1]=true;
               if(arr[i]==i+1)continue;
               else{
                   int next=arr[i];
                   while(visited[next]!=true){
                       visited[next]=true;
                       ++count;
                       next=arr[next-1];
                   }
               }
            }
        }
        return count;
    }
