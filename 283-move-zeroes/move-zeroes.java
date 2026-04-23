class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int read=0,write=0;
        while(read<n){
           if(nums[read]!=0){
            nums[write]=nums[read];
            write++;
           }
           read++; 
        }
        while(write<n){
            nums[write]=0;
            write++;
        }
    }
}