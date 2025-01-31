public class NutsAndBolts{
	
	static void quickSort(int[] nuts,int[] bolts,int l,int h){
		if(l<h){
			int pivot=partition(nuts,l,h);
			partition(bolts,l,h,nuts[pivot]);
			quickSort(nuts,bolts,l,pivot);
			quickSort(nuts,bolts,pivot+1,h);
		}
	}

	static void partition(int[] arr,int l,int h,Integer pivot){
		int i=l-1,j=h;
		while(i<h){
			do{
			 ++i;
			}while(i<(arr.length) && arr[i]<=pivot);

			do{
			 --j;
			}while(arr[j]>pivot);

			if(j>i){
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			}else{
			 break;
			}
			
		}
	}

	static int partition(int[] arr,int l,int h){
		int pivot=arr[l];
		int i=l,j=h;
		while(i<h){
			do{
			 ++i;
			}while(i<(arr.length) && arr[i]<=pivot);

			do{
			 --j;
			}while(arr[j]>pivot);

			if(j>i){
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			}else{
			 break;
			}
			
		}
		int temp2=arr[j];
		arr[j]=arr[l];
		arr[l]=temp2;
		return j;
	}
	
	static void printAll(int[] arr){
		System.out.print("\n");
		for(int i=0;i<arr.length;++i){
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String args[]){
		int nuts[]={2,1,3,4,7,6,9};
		int bolts[]={3,4,2,1,9,7,6};
		quickSort(nuts,bolts,0,nuts.length);
		printAll(nuts);
		printAll(bolts);
		
		
	}
}