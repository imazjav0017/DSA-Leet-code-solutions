class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        int left=0,right=0;
        int zeroes=0;
        while(right<n){
            if(nums[right]==0){
                zeroes++;
            }
            while(left<=right && zeroes>1){
                if(nums[left]==0)
                    zeroes--;
                left++;
            }
            int len=(right-left+1)-1;
            maxLen=Math.max(len,maxLen);
            right++;
        }
        return maxLen;
    }
}