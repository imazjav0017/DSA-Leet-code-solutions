class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=1;
        int read=1,write=1,lastRead=nums[0];
        while(read<n){
            if(nums[read]!=lastRead){
                nums[write]=nums[read];
                write++;
                k++;
                lastRead=nums[read];
            }
            read++;
        }
        return k;
    }
}