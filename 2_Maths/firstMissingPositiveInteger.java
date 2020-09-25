class Solution {//50%
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;++i){
            if(!(nums[i]<=0 || nums[i]>nums.length)){
                set.add(nums[i]);
            }
        }
        for(int i=1;i<=nums.length;++i){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }
}

class Solution { //50%
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set=new HashSet();
        for(int num:nums){
            set.add(num);
        }
        int firstPosNumberMissing=1;
        for(int num:nums){
            if(num==firstPosNumberMissing){
                do{
                   firstPosNumberMissing++; 
                }while(set.contains(firstPosNumberMissing));
            }
        }
        return firstPosNumberMissing;
    }
}
