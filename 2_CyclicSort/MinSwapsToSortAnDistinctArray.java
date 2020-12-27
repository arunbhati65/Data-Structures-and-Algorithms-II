int minSwapCount(int[] arr){
    int count=0;
    boolean[] visited=new boolean[arr.length];
    for(int i=0;i<arr.length;++i){
        if(visited[i] || arr[i]==i) continue;
        visited[i]=true;
        int cycleCount=0;
        int c=i;
        while(!visited[c]){
            c=arr[c];
            visited[c]=true;
            ++cycleCount;
        }
        count=count+cycleCount-1;
    }
    return count;
}