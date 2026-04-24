class Solution {
    public void sortColors(int[] nums) {
        int write0=0,write2=nums.length-1;
        int read=0;
        while(read<=write2){
            if(nums[read]==0){
                swap(nums,read,write0);
                write0++;
                read++;
            }
            else if(nums[read]==1){
                read++;
            }
            else{
                swap(nums,read,write2);
                write2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}