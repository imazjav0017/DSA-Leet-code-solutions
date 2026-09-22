class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>[]dp=new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
        }
        int res=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                int previous=dp[j].getOrDefault(diff,1);
                int current=previous+1;
                dp[i].put(diff,Math.max(dp[i].getOrDefault(diff,0),current));
                res=Math.max(res,dp[i].get(diff));
            }
        }
        return res;
    }
}