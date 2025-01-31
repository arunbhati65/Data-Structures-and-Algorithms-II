/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
*/
class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        helper(candidates,0,target,result,new ArrayList<Integer>());
        return result; 
    }
    
    void helper(int[] arr,int index,int target,List<List<Integer>> result,List<Integer> temp){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<arr.length;++i){
            if(target>=arr[i]){
                temp.add(arr[i]);
                helper(arr,i,target-arr[i],result,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}