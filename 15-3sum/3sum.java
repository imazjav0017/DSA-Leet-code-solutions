class Solution {
    /*
    [-100,-70,-60,110,120,130,160]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>>res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(nums[i]>0)
                break;
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                }
                if(sum<0){
                    left++;
                }
                else  right--;
            }
        }
        List<List<Integer>> list = new ArrayList<>(res);
        return list;
    }
}