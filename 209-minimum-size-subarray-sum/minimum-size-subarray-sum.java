class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minLen=n+1;
        int left=0,right=0;
        int sum=0;
        while(right<n){
            sum+=nums[right];
            while(left<=right && sum>=target){
                minLen=Math.min(minLen,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return minLen>n?0:minLen;
    }
}