public class BubbleSort{//o(n2) //detect if already sorted

	static void doBubbleSort(int arr[]){
		Boolean swapped=true;
		while(swapped){
			swapped=false;
			for(int i=0;i<arr.length-1;++i){
				if(arr[i]>arr[i+1]){
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					swapped=true;
				}
			}
		}
	}
	
	static void printAll(int[] arr){
		System.out.print("All Elements are : ");
		for(int i=0;i<arr.length;++i){
			System.out.print(arr[i]+"-");
		}
	}

	public static void main(String args[]){
		int arr[]={21,32,123,12,3,12,434,1};
		doBubbleSort(arr);
		printAll(arr);
	}

}