public class SelectionSort{//o(n2) //Selection sort as it selects the lowest one in secound iteration and put at first iteration index

	static void doSelectionSort(int arr[]){
		
		for(int j=0;j<arr.length;++j){
			int min=j;
			for(int i=j;i<arr.length;++i){
				if(arr[min]>arr[i]){
					min=i;
				}
			}
			if(j!=min){
				int temp=arr[j];
				arr[j]=arr[min];
				arr[min]=temp;
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
		doSelectionSort(arr);
		printAll(arr);
	}

}