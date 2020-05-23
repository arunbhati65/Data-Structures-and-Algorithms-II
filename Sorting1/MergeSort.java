public class MergeSort{
    static void doMergeSort(int [] arr,int l,int h){
	if(h>l){
        	int mid=(l+(h-l)/2);
		doMergeSort(arr,l,mid);
		doMergeSort(arr,mid+1,h);
		merge(arr,l,mid,h);
	}
    }
	
    static void merge(int[] arr,int l,int mid,int high){
	int[] left=new int[mid-l+1];
	int[] right=new int[high-(mid+1)+1];
	for(int i=l;i<=mid;++i){
		left[i-l]=arr[i];
	}
	for(int i=mid+1;i<=high;++i){
		right[i-(mid+1)]=arr[i];
	}
	int indexL=0; int indexR=0; int mainIndex=l;
	while(indexL<left.length && indexR<right.length){
		if(left[indexL]<right[indexR]){
			arr[mainIndex++]=left[indexL++];
		}else{
			arr[mainIndex++]=right[indexR++];
		}
	}
	while(indexL<left.length){
		arr[mainIndex++]=left[indexL++];
	}
	while(indexR<right.length){
		arr[mainIndex++]=right[indexR++];
	}

    }		

    static void printAll(int[] arr){
        System.out.print("\nAll Elements after partitioning are : ");
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i]+"-");
        }
    }

    public static void main(String args[]){
        int [] arr={12,2132,12,3,1,32,53,1,212,42};
        doMergeSort(arr,0,arr.length-1);
        printAll(arr);
    }

}