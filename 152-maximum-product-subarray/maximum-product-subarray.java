class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0],min=nums[0];
        int ans=nums[0];
       for(int i=1;i<nums.length;i++){
        int x=nums[i];
        int a=x;
        int b=max*x;
        int c=min*x;
        max=Math.max(a,Math.max(b,c));
        min=Math.min(a,Math.min(b,c));
        ans=Math.max(max,ans);
       }
        return ans;
    }
}