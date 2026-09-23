class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        //dp[i][j]=min score to triangulate i to j
        int[][]dp=new int[n][n];
        for(int length=2;length<n;length++){
            for(int i=0;i+length<n;i++){
                int j=i+length;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int score=dp[i][k]+values[i]*values[k]*values[j]+dp[k][j];
                    dp[i][j]=Math.min(dp[i][j],score);
                }
            }
        }
        return dp[0][n-1];
    }
}