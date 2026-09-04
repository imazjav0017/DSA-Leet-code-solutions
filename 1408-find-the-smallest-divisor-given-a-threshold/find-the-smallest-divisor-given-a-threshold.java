class Solution {
    boolean canDo(int[]nums,int div,int t){
        long sum=0;
        for(int i=0;i<nums.length;i++){
            long d = (long) Math.ceil((double) nums[i] / div);
            sum+=d;
            if(sum>t)
                return false;
        }
        return sum<=t;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
            max=Math.max(max,nums[i]);

        int left=1, right=max+1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(nums,mid,threshold)){
                right=mid;
            }
            else left=mid+1;
        }
        return left;
    }
}