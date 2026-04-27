class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int maxSum=0,sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxSum=sum;

        for(int i=1;i+k-1<n;i++){
            sum=sum-nums[i-1]+nums[i+k-1];
            maxSum=Math.max(sum,maxSum);
        }
        return (double)maxSum/k;
    }
}