class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        return Math.max(robHouses(nums,0,n-2),robHouses(nums,1,n-1));
    }
    int robHouses(int[]nums, int start, int end){
        if(start==end)
            return nums[start];
        int prev2=nums[start];
        int prev1=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int current=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}