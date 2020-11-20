public class permutation {

    public static void printPermutation(char[] arr){
        backTracking(arr,0);
    }

    static void backTracking(char[] arr,int index){//String is prepared before this index
        if(index==arr.length-1){
            System.out.println(String.valueOf(arr));
            return;
        }
        for(int i=index;i<arr.length;++i){
            swap(arr,i,index);
            backTracking(arr, index+1);
            swap(arr,i,index);
        }
    }
    
    private static void swap(char[] arr, int i, int index) {
        char temp=arr[i];
        arr[i]=arr[index];
        arr[index]=temp;
    }

    public static void main(String[] args) {
        printPermutation("123".toCharArray());
    }
}
