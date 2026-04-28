class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int low=nums[0]-k;
        int high=nums[0]+k;
        int left=0,right=0;
        int maxLen=0;
        while(right<n){
            int tempLow=nums[right]-k;
            while(tempLow>high){
                left++;
                low=nums[left]-k;
                high=nums[left]+k;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}