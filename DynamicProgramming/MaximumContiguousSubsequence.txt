import java.lang.Math;


class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int ans=nums[0];
        int start =0,end=0;
        int tillHere=nums[0];
        for(int i=1;i<nums.length;++i){
            if(tillHere+nums[i]<nums[i]){
                start=i;
            }
            tillHere=Math.max(tillHere+nums[i],nums[i]);
            if(tillHere<=0){
                start=i+1;
            }
            if(ans<tillHere){
                end=i;
            }
            ans=Math.max(ans,tillHere);
            
        }
        System.out.println(start+" ->"+ end);
        return ans;
    }
}


public class MaximumContiguousSubsequence{ // 

   	int max=Integer.MIN_VALUE;
  	public int maxSubArray(int[] nums) {
        	 helper(nums, nums.length-1);
        	 return max;
  	}

    	int helper(int[] nums,int h){
      		 if(h==0) return max= nums[0];
     		 int currMax=Math.max(nums[h],nums[h]+helper(nums,h-1));
       		 max=Math.max(max,currMax);
       		 return currMax;
    	}


	static int MCS(int arr[]){ //o(n2)
		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;++i){
			int sum=0;
			for(int j=i;j<arr.length;++j){
				sum=sum+arr[j];
				maxSum=Math.max(maxSum,sum); // capture every max value
			}
		}
		return maxSum;
	}

	static int MCSLinear(int arr[]){ //o(n)
		
		int [] A=new int[arr.length];
		A[0]=arr[0];
		int maxSum=arr[0];
		for(int i=1;i<arr.length;++i){
			A[i]=Math.max(arr[i]+A[i-1],arr[i]);
			maxSum=Math.max(maxSum,A[i]); // capture every max value

		}
		return maxSum;
	}

    static int solve(String S){ // linear revised
        char[] A=S.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('A',-1);
        map.put('C',1);
        int[] M=new int[S.length()];
        M[0]=map.get(A[0]);
        int maxSum=map.get(A[0]);
        for(int i=1;i<A.length;++i){
            M[i]=Math.abs(map.get(A[i]))>Math.abs(M[i-1]+map.get(A[i]))?map.get(A[i]):M[i-1]+map.get(A[i]);
            maxSum=Math.abs(maxSum)>Math.abs(M[i])?maxSum:M[i];
        }
        maxSum=Math.abs(maxSum);
        return maxSum;
    }
	
	public static void main(String args[]){
		int arr[]={-2,11,-4,13,-5,2};	//20	
		
		System.out.println("Max Value of Contiguous Subsequence using o(n2) - "+MCS(arr));
		System.out.println("Max Value of Contiguous Subsequence using o(n) - "+MCSLinear(arr));

	}
}