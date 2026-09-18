class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][]dp=new int[m][n];
        for(int r=0;r<m;r++){
            if(obstacleGrid[r][0]==1)
                break;
            dp[r][0]=1;
        }
        for(int c=0;c<n;c++){
            if(obstacleGrid[0][c]==1)
                break;
            dp[0][c]=1;
        }
        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                if(obstacleGrid[r][c]!=1)
                    dp[r][c]=dp[r-1][c]+dp[r][c-1];
            }
        }
        return dp[m-1][n-1];
    }
}