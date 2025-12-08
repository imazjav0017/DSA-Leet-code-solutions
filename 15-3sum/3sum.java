class Solution {
    /*
    [-100,-70,-60,110,120,130,160]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            if(nums[i]>0)
                break;
            int left=i+1;
            int right=n-1;
            int target=-nums[i];
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1])left++;
                    while(left<right && nums[right]==nums[right+1])right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
                

            }
        }
        return res;
    }
}