//Combinations Combinations of a Array
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list=new LinkedList<>();
        List<Integer> newList=new LinkedList<>();
        list.add(newList);
        helper(nums,newList,0);
        return list;
    }
    
    void helper(int[] nums,List<Integer> newList,int l){
        for(int i=l;i<nums.length;++i){
            newList.add(nums[i]);
            list.add(new LinkedList(newList));
            if(i+1!=nums.length) {
                helper(nums,newList,i+1);                
            }
            newList.remove(newList.size()-1);
        }
        
    }
    
}