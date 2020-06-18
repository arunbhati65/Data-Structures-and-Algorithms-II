class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list=new LinkedList<>();
        if(nums.length==0) return list;
        helper(nums,0,nums.length-1);
        return list;
    }
    
    void helper(int[] nums,int l,int h){
        if(l==h){
            List<Integer> newList=new ArrayList<>();
            for(int i=0;i<nums.length;++i){
                newList.add(nums[i]);
            }
            list.add(newList);
        }else{
            for(int i=l;i<=h;++i){
                swap(nums,i,l);
                helper(nums,l+1,h);
                swap(nums,i,l);
            }
        }
    }
    
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}