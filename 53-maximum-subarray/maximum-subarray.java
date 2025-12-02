class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0 || nums==null) return 0;
        int maxSoFar=nums[0];
        int maxEndingHere=nums[0];
        for (int i=1;i<n;i++){
            maxEndingHere=Math.max(nums[i],nums[i]+maxEndingHere);
            maxSoFar=Math.max(maxSoFar,maxEndingHere);
        }
        return maxSoFar;
    }
}