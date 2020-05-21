import java.lang.Math;

public class MaximumContiguousSubsequence{
	
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

	static int MCSLinear(int arr[]){ //o(n2)
		
		int [] A=new int[arr.length];
		A[0]=arr[0];
		int maxSum=arr[0];
		for(int i=1;i<arr.length;++i){
			A[i]=Math.max(arr[i]+A[i-1],arr[i]);
			maxSum=Math.max(maxSum,A[i]); // capture every max value

		}
		return maxSum;
	}
	
	public static void main(String args[]){
		int arr[]={-2,11,-4,13,-5,2};	//20	
		
		System.out.println("Max Value of Contiguous Subsequence using o(n2) - "+MCS(arr));
		System.out.println("Max Value of Contiguous Subsequence using o(n) - "+MCSLinear(arr));

	}
}