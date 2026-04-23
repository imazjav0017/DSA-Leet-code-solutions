class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int res=0;
        int read=0,write=0;
        while(read<n){
            if(nums[read]!=val){
                nums[write]=nums[read];
                write++;
                res++;
            }
            read++;
        }
        return res;
    }
}