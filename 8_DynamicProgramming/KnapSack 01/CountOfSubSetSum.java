public class CountOfSubSetSum {
    
    int countOfSubSetSum(int[] arr,int sum){
        return helper(arr,sum,0);
    }

    helper(int[] arr,int sum,int index){
        if(index>=arr.length || sum<0) return 0;
        if(sum==0) return 1;
        int count=0;
        if(arr[index]<=sum){
            count=helper(arr,sum-arr[index],index+1);
        }
        return count+helper(arr,sum,index+1);
    }
}

public class CountOfSubSetSum {
    
    int countOfSubSetSum(int[] arr,int sum){
        if(sum==0 || arr.length==0) return 0;
        Integer[][] memo=new Integer[arr.length][sum+1];
        for(int i=0;i<arr.length;++i){
            memo[i][0]=1;
        }
        for(int w=1;w<sum+1;++w){
            if(arr[i]==sum)
            memo[0][w]=1;
        }
        for(int i=1;i<arr.length;++i){
            for(int w=1;w<sum+1;++w){
                int count=0;
                if(arr[i]<=w){
                    count=memo[i-1][w-arr[i]];
                }
                count=count+memo[i-1][w];
                memo[i][w]=count;
            }
        }
        return memo[arr.length-1][sum];
    }
}