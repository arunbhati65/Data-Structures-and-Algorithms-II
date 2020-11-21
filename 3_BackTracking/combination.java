public class combination {
    public static void printCombinationSubString(char[] arr){
        System.out.println("");
        for(int i=0;i<arr.length;++i){
            backTracking(arr,i,arr[i]+"");
        }
    }

    static void backTracking(char[] arr,int index,String str){//String is prepared before this index
        System.out.println(str);
        if(index==arr.length-1) return;
        backTracking(arr, index+1, str+arr[index+1]);
    }
    
    public static void main(String[] args) {
        printCombination("123".toCharArray());
    }
}
