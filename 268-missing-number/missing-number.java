class Solution {
    public int missingNumber(int[] nums) {
        int size=nums.length;
        int sum=size*(size+1)/2;
        int actualSum=0;
        for (int i=0;i<size;i++){
            actualSum+=nums[i];
        }
        return sum-actualSum;
    }
}