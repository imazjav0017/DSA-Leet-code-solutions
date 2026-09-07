class Solution {
    boolean canDo(int[]nums,int mid,int k){
        int c=1;
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                c++;
                sum=nums[i];
            }
            if(c>k)
                return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int max=nums[0],sum=0;
        for(int i:nums){
            max=Math.max(max,i);
            sum+=i;
        }
        int left=max,right=sum+1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(nums,mid,k)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}