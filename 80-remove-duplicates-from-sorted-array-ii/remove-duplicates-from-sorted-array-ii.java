class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=1;
        int read=1, write=1;
        int lastRead=nums[0], lastReadC=1;
        while(read<n){
            if(nums[read]!=lastRead ||lastReadC<2){
                nums[write]=nums[read];
                write++;
                k++;
                if(lastRead==nums[read]){
                    lastReadC++;
                }
                else{
                    lastRead=nums[read];
                    lastReadC=1;
                }
            }
            read++;
        }
        return k;

    }
}