class findKthLargest{
    public int findKthLargest(int[] nums, int k) {
        MaxHeap heap=new MaxHeap(nums);
        heap.buildHeap();
        for(int i=0;i<k-1;++i){
            heap.extract();
        }
        return heap.extract();
    }
    
}

public class MaxHeap{
	static int [] arr;
	static int size;
	
	MaxHeap(int size){
		this.size=size;
		this.arr=new int[size];
	}


	MaxHeap(int arr[]){
		this.size=arr.length;
		this.arr=arr;
	}
	
	public static void printAllElements(){
		System.out.println("\nprinting all heap elements");
		for(int i=0;i<size;++i){
			System.out.print(arr[i]+"-");			
		}
	}
	
	public static void buildHeap(){ // bottom to top //o(n)
		for(int i=(size-2)/2;i>=0;--i){
			Heapify(i);
		}
	}
	
	private static void swap(int x,int y){
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	
	public static void Heapify(int root){ //top to bottom - o(logn)
		int left=2*root+1;
		int right=2*root+2;

		int largest=root;
		if(right<size && arr[largest]<arr[right]){
			largest=right;
		}
		if(left<size && arr[largest]<arr[left]){
			largest=left;
		}
		if(largest!=root){
			swap(root,largest);
			Heapify(largest);
		}
	}

	public static int extract(){
		if(size==0) return Integer.MIN_VALUE;
		if(size==1){
			size--;
			return arr[0];
		}
		swap(0,size-1);
		--size;
		Heapify(0);
		return arr[size];
	}

}