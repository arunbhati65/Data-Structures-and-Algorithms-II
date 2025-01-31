class Solution {
    List<List<Integer>> combinations=new ArrayList<>();
    public List<List<Integer>> combinationSubSequenceSumEqulasTarget(int[] arr, int target) {
        ArrayList<Integer> list=new ArrayList<>();
        helper(arr,target,list,0);
        return combinations;
    }
    
    void helper(int[] arr,int target,ArrayList<Integer> list,int index){
        if(target<0) return;
        if(target==0){
            combinations.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=index;i<arr.length;++i){
            if(target>=arr[i]){
                list.add(arr[i]);
                helper(arr,target-arr[i],list,i);
                list.remove(list.size()-1);                
            }
        }
    }
}