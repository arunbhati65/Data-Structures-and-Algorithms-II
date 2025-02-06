//o(n2)

public class InsertionSort{
	static void doInsertionSort(int arr[]){	
		for(int i=1;i<arr.length;++i){ //first loop provides key
			int j,key=arr[i];

			//2nd loop insert the key at right position
			for(j=i-1;j>=0 && arr[j]>key;--j){ // before j all are sorted;   arr[j]>key condition of being unsorted
				arr[j+1]=arr[j];
			}	
			arr[j+1]=key;   
					//for loop go ahead bhavuk hoke 
				        //j is the position i.e arr[j]<key
					//arr[j+1]th element is already shifted to arr[j+2]
					//so no need of swap just allocate j+1 th elemt with key
					//Insertion Sort- as inserting right element at right place.		
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
		doInsertionSort(arr);
		printAll(arr);
	}

}