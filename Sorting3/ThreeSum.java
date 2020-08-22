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

class Solution {//MAP
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length!=0){
            Integer prev=null;
            for(int i=0;i<nums.length;++i){
                if(prev!=null && prev==nums[i]){
                    continue;
                }
                prev=nums[i];   
                int A=nums[i]*-1;
                twoSum(result,nums,i,A);
            }   
        }
        return result;
    }

    void twoSum(List<List<Integer>> result,int[] nums,int AIndex, int sum) {
        int l=AIndex+1,h=nums.length-1;
        while(l<h){
            int BC=nums[l]+nums[h];
            if(BC>sum || (h<nums.length-1 && nums[h]==nums[h+1])){
                h--;
            }else if(BC<sum || (l>AIndex+1 && nums[l]==nums[l-1])){
                l++;
            }else{
                result.add(Arrays.asList(nums[AIndex],nums[l++],nums[h--]));
            }
            
        }
    }
}