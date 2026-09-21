class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
       int[]tails=new int[n];
       int size=0;
       for(int i=0;i<n;i++){
        int left=0,right=size;
        while(left<right){
            int mid=left+(right-left)/2;
            if(tails[mid]>=nums[i]){
                right=mid;
            }
            else{
                left++;
            }
        }
        if(left==size){
            tails[left]=nums[i];
            size++;
        }
        else{
            tails[left]=nums[i];
        }
       }
       return size;
    }
}