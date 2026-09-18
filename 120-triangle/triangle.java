class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0]=triangle.get(0).get(0);
        for(int r=1;r<n;r++){
            for(int c=0;c<triangle.get(r).size();c++){
                int num=triangle.get(r).get(c);
                int prevValue=c==0?Integer.MAX_VALUE:dp[r-1][c-1];
                dp[r][c]=num+Math.min(dp[r-1][c],prevValue);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int c=0;c<n;c++){
            min=Math.min(min,dp[n-1][c]);
        }
        return min;
    }
}