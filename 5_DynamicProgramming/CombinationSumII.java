/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        helper(candidates,0,target,result,new ArrayList<Integer>());
        return result;
    }
    
    void helper(int[] arr,int index,int target,List<List<Integer>> result,List<Integer> selected){
        if(target<0){
          return;   
        }
        if(target==0){
            result.add(new ArrayList<>(selected));
            return;
        }
        for(int i=index;i<arr.length;++i){
            if(target>=arr[i] && (i==index || arr[i]!=arr[i-1])){
                selected.add(arr[i]);
                helper(arr,i+1,target-arr[i],result,selected);
                selected.remove(selected.size()-1);
            }
        }
    }
}