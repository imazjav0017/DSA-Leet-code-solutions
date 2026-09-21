class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        //dp[x]=length of LIS ending at index X
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        for(int d:dp){
            max=Math.max(max,d);
        }
        return max;
    }
}