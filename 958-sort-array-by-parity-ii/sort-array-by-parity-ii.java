class Solution {
    void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int[] sortArrayByParityII(int[] nums) {
        int odd=1,even=0;
        int n=nums.length;
        while(even<n && odd<n){
            if(nums[even]%2==0){
                even+=2;
            }
            else if(nums[odd]%2==1){
                odd+=2;
            }
            else{
               swap(nums,even,odd);
               even+=2;
               odd+=2;
            }
        }
        return nums;
    }
}