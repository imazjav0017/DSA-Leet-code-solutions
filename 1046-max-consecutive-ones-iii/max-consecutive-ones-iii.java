class Solution {
    public int longestOnes(int[] nums, int k) {
        int ones=0;
        int max=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==1)
                ones++;
            while(ones+k<(right-left+1)){
                if(nums[left]==1)
                    ones--;
                left++;
            }
            max=Math.max(max,right-left+1);            
        }
        return max;
    }
}