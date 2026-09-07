class Solution {
    boolean canDo(int[]nums,int mid,int k){
        int left=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
            while(nums[right]-nums[left]>mid){
                left++;
            }
            count+=right-left;
            if(count>=k)
                return true;
        }
        return false;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);;
        int max=nums[nums.length-1],min=nums[0];
        int left=0, right=Math.abs(max-min);
        while(left<right){
            int mid=left+(right-left)/2;
            if(canDo(nums,mid,k))right=mid;
            else left=mid+1;
        }
        return left;
    }
}