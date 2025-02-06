public class SubSetSumExistOrNot {
    boolean subsetSumExist(int[] arr,int sum){
        return helper(arr,sum,0);
    }

    helper(int[] arr,int sum,int index){
        if(index>=arr.length || sum<0) return false;
        if(sum==0) return true;
        boolean exist=false;
        if(arr[index]<=sum){
            exist=helper(arr,sum-arr[index],index+1);
        }
        if(exist) return true;
        return helper(arr,sum,index+1);
    }
}

public class SubSetSumExistOrNot {
    boolean subsetSumExist(int[] arr,int sum){
        if(sum==0) return true;
        if(sum<0 || arr.length==0) return false;
        boolean[][] memo=new boolean[arr.length][sum+1];
        for(int i=0;i<arr.length;++i){
            memo[i][0]=true;
        }
        for(int w=1;w<sum+1;++w){
            if(arr[0]==w){
                memo[0][w]=true;
            }
        }
        for(int i=1;i<arr.length;++i){
            for(int w=1;w<sum+1;++w){
                boolean result=false;
                if(arr[i]<=w){
                    result=memo[i-1][w-arr[i]];
                }
                memo[i][w]=result||memo[i-1][w];
            }
        }
        return memo[arr.length-1][sum];
    }
}
