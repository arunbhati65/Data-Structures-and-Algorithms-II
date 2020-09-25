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
