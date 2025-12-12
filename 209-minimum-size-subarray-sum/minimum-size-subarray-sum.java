class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0, right=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        while(right<n){
            sum+=nums[right];
            //System.out.println("SUM: "+sum+" LR: "+left+" "+right);
            while(sum>=target && left<=right){
                //System.out.println("SUM1: "+sum+" LR: "+left+" "+right);
                if(left!=right){
                    sum-=nums[left];
                }
                res=Math.min(res,right-left+1);
                left++;
            }
            right++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}