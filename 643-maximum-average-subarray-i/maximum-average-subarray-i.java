class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=k-1;
        double sum=0;
        for(int i=left;i<=right;i++){
            sum+=nums[i];
        }
        double maxAvg=sum/k;
        right++;
        left++;
         
        while(right<n){
            sum+=nums[right];
            sum-=nums[left-1];
            maxAvg=Math.max(maxAvg,sum/k);
            left++;
            right++;
        }
        return maxAvg;
    }
}