class Solution {
    public int removeDuplicates(int[] arr) {
       int index=0; 
       HashSet<Integer> set=new HashSet<>(); 
       for(int i=0;i<arr.length;++i){
            if(!set.contains(arr[i])){
                set.add(arr[i]); 
                arr[index]=arr[i];
                ++index;
            }
       }
        return index; 
    }
}