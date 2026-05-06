class Solution {
    int atMost(int[]nums, int n, int k){
        int left=0;
        int right=0;
        int sum=0;
        int ans=0;
        while(right<n){
            sum+=nums[right];
            while(left<=right && sum>k){
                sum-=nums[left];
                left++;
            }
            if(left<=right)ans+=right-left+1;
            right++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        return atMost(nums,n,goal)-atMost(nums,n,goal-1);
    }
}