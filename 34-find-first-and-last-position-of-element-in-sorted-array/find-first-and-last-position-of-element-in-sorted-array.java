class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int left=0, right=n;
        boolean found=false;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                if(nums[mid]==target)found=true;
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        if(!found)
            return new int[]{-1,-1};
        
        int[]res=new int[2];
        res[0]=left;
        left=0;
        right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        res[1]=left-1;
        return res;
    }
}