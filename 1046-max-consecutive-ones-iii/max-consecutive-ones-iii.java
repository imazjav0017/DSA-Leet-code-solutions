class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int maxLen=0;
        int left=0,right=0;
        int count=0;
        while(right<n){
            if(nums[right]==1)
                count++;
            while((right-left+1)-count>k){
                if(nums[left]==1)
                    count--;
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}