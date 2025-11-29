class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int lsi=0;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==0 && nums[i+1]!=0){
                nums[lsi]=nums[i+1];
                lsi++;
                for(int j=i+1;j>=lsi;j--){
                    nums[j]=0;
                }
            }
            else if (nums[i]!=0) lsi++;
        }
    }
}