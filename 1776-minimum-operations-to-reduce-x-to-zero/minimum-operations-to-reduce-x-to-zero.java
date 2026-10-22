class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int target=sum-x;
        int len=-1;
        int left=0;
        int windowSum=0;
        for(int right=0;right<n;right++){
            windowSum+=nums[right];
            while(left<=right && windowSum>target){
                windowSum-=nums[left];
                left++;
            }
            if(windowSum==target){
                len=Math.max(len,right-left+1);
            }
        }
        return len==-1?-1:n-len;
    }
}