class Solution {
    Set<List<Integer>> result=new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for(int k=0;k<nums.length;++k){
            twoSum(k,nums);
        }
        return new ArrayList<>(result);
    }

    private void twoSum(int k,int[] nums){
        int l=0,h=nums.length-1;

        while(l<h && l!=k && h!=k){
            int sum=nums[l]+nums[h];
            if(sum+nums[k]==0){
                List<Integer> list=new LinkedList<>();
                if(nums[l]<nums[k]){  
                    list.add(nums[l]);
                    list.add(Math.min(nums[h],nums[k]));
                    list.add(Math.max(nums[h],nums[k]));
                }else{
                    list.add(nums[k]);
                    list.add(nums[l]);
                    list.add(nums[h]);
                }
                result.add(list); ++l;
            }else if(sum>-nums[k]){
                --h;
            }else if(sum<-nums[k]){
                ++l;
            }
        }
    }
}