class Solution {
    private void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int left=0, right=0;
        while(right<n){
            if(nums[right]!=val){
                if(left!=right){
                    swap(nums,left,right);
                }
                left++;
                right++;
            }
            else {
                if(left!=right && nums[left]!=val){
                    swap(nums,left,right);
                    left++;
                }
                right++;
            }
        }
        return left;
    }
}