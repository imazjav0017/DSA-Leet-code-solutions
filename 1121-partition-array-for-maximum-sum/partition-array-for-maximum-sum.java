class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        //dp[i]=max sum using first i numbers
        int[]dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int max=0;
            for(int len=1;len<=k && len<=i;len++){
                max=Math.max(max,arr[i-len]);
                int candidate=dp[i-len]+max*len;
                dp[i]=Math.max(dp[i],candidate);
            }
        }
        return dp[n];
    }
}