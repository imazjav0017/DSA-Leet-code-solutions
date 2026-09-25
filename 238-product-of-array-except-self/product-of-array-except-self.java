class Solution {
    public int[] productExceptSelf(int[] nums) {
     int n=nums.length;
     int prefix=1;
     int[]res=new int[n];
     for(int i=0;i<n;i++){
        res[i]=prefix;
        prefix=prefix*nums[i];
     }
     int suffix=1;
     for(int i=n-1;i>=0;i--){
        res[i]=res[i]*suffix;
        suffix=suffix*nums[i];
     }
     return res;
    }
}