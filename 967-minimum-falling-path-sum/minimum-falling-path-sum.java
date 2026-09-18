class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix[0].length;
        int[][]dp=new int[n][n];
        for(int c=0;c<n;c++){
            dp[0][c]=matrix[0][c];
        }
        for(int r=1;r<n;r++){
            for(int c=0;c<n;c++){
                int next=c==n-1?Integer.MAX_VALUE:dp[r-1][c+1];
                int prev=c==0?Integer.MAX_VALUE:dp[r-1][c-1];
                int minHere=Math.min(next,prev);
                dp[r][c]=matrix[r][c]+Math.min(dp[r-1][c],minHere);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int c=0;c<n;c++){
            min=Math.min(dp[n-1][c],min);
        }
        return min;
    }
}