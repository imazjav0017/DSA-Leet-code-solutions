class Solution {
    boolean canDo(int[]nums,int mid, int max){
        int op=0;
        for(int i=0;i<nums.length;i++){
            op+=(long) Math.ceil((double) nums[i] / mid) - 1;
            if(op>max)
                return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max=nums[0];
        for(int i:nums){
            max=Math.max(max,i);
        }
        int left=1,right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(nums,mid,maxOperations))
                right=mid;
            else left=mid+1;
        }
        return left;
    }
}