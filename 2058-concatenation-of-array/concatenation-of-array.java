class Solution {
    public int[] getConcatenation(int[] nums) {
        int[]res=new int[2*nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            res[i]=nums[i];
            res[i+n]=nums[i];
        }
        return res;
    }
}