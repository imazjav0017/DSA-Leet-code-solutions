class Solution {
    int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    int dfs(int[][]matrix, int r, int c, int[][]memo, int m, int n){
        if(memo[r][c]!=0)
            return memo[r][c];
        memo[r][c]=1;
        for(int[]dir:dirs){
            int nr=dir[0]+r, nc=dir[1]+c;
            if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[nr][nc]>matrix[r][c])
                memo[r][c]=Math.max(memo[r][c],1+dfs(matrix,nr,nc,memo,m,n));
        }
        return memo[r][c];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][]memo=new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dfs(matrix,i,j,memo,m,n));
            }
        }
        return max;
    }
}