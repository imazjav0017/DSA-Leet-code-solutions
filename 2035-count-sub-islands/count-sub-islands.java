class Solution {
    private boolean dfs(int r, int c, int[][]grid1,int[][]grid2,boolean[][]visited){
        visited[r][c]=true;
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        boolean isEqual=true;
        for(int[]d:dirs){
            int nr=r+d[0],nc=c+d[1];
            if(nr<0||nc<0||nr>=grid1.length||nc>=grid1[0].length|| visited[nr][nc]||grid2[nr][nc]==0)
                continue;
            boolean res= dfs(nr,nc,grid1,grid2,visited);
            if(isEqual){
                isEqual=res;
            }
        }
        if(grid1[r][c]!=grid2[r][c])
            return false;
        return isEqual;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid1.length,n=grid1[0].length;
        boolean[][]visited=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid2[i][j]==1){
                   boolean isEqual= dfs(i,j,grid1,grid2,visited);
                   if(isEqual)
                    res++;
                }
            }
        }
        return res;
    }
}