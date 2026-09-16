class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length,n=mat[0].length;
        int[][]prefix=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefix[i+1][j+1]=mat[i][j]+prefix[i][j+1]+prefix[i+1][j]-prefix[i][j];
            }
        }
        int[][]res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int row1=i-k>=0?i-k:0;
                int row2=i+k>=m?m-1:i+k;
                int col1=j-k>=0?j-k:0;
                int col2=j+k>=n?n-1:j+k;
                res[i][j]=prefix[row2+1][col2+1]-prefix[row1][col2+1]-prefix[row2+1][col1]+prefix[row1][col1];
            }
        }
        return res;
    }
}