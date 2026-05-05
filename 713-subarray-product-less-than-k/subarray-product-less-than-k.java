class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int prod=1;
        int left=0,right=0;
        while(right<n){
            prod=prod*nums[right];
            while(left<=right && prod>=k){
                prod=prod/nums[left];
                left++;
            }
            int len=right-left+1;
            int sumN=(len*(len+1))/2;
            int sumNMinus1=((len-1)*len)/2;
            count=count + (sumN-sumNMinus1);
            right++;
        }
        return count;

    }
}