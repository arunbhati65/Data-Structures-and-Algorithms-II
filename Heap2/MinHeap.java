public class MinHeap{
	static int [] arr;
	static int size;
	
	MinHeap(int size){
		this.size=size;
		this.arr=new int[size];
	}


	MinHeap(int arr[]){
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
			minHeapify(i);
		}
	}
	
	private static void swap(int x,int y){
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	
	public static void minHeapify(int root){ //top to bottom - o(logn)
		int left=2*root+1;
		int right=2*root+2;

		int smallest=root;
		if(right<size && arr[smallest]>arr[right]){
			smallest=right;
		}
		if(left<size && arr[smallest]>arr[left]){
			smallest=left;
		}
		if(smallest!=root){
			swap(root,smallest);
			minHeapify(smallest);
		}
	}

	public static int extractMin(){
		if(size==0) return Integer.MAX_VALUE;
		if(size==1){
			size--;
			return arr[0];
		}
		swap(0,size-1);
		--size;
		minHeapify(0);
		return arr[size];
	}

	public static void sort(){
		System.out.print("\nSorted numbers:-");
		while(size!=0){
			System.out.print(extractMin()+"-");
		}
	}

	public static void main(String args[]){
		int arr[]={2,0,21,1221,12,233,3,1};
		MinHeap minHeap=new MinHeap(arr);
		buildHeap();
		printAllElements();
		System.out.println("\nhighest prority element in min heap is: "+extractMin());
		printAllElements();
		sort();
	}

}