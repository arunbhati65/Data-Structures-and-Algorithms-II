class Solution {
    public int[][] kClosest(int[][] points, int K) {
        helper(points,K,0,points.length);
        int[][] result=new int[K][2];
        for(int i=0;i<K;++i){
            result[i][0]=points[i][0];
            result[i][1]=points[i][1];
        }
        return result;
    }
    
    void helper(int[][] nums, int k,int l,int h){
            int pivot=partition(nums,l,h);
            if(pivot==k-1){
                return ;
            }
            else if(k-1<pivot){
                 helper(nums,k,l,pivot);
            }else{
                 helper(nums,k,pivot+1,h);                
            }
    }
    
    int partition(int[][] nums,int l,int h){
        int[] pivot=nums[l];
        int i=l,j=h;
        while(i<j){
            do{
                ++i;
            }while(i<nums.length && getEuclideanDistance(nums[i])<=getEuclideanDistance(pivot));

            do{
               --j; 
            }while(getEuclideanDistance(nums[j])>getEuclideanDistance(pivot));
            if(i>j){
                break;
            }else{
                int[] temp1=nums[j];
                nums[j]=nums[i];
                nums[i]=temp1;
            }
        }
        int[] temp2=nums[j];
        nums[j]=pivot;
        nums[l]=temp2;  
        return j;
    }
    
    
    Double getEuclideanDistance(int ob[]){
        int x=ob[0],y=ob[1];
        int compute=x*x+y*y;
        return Math.sqrt(compute);
    }

}

