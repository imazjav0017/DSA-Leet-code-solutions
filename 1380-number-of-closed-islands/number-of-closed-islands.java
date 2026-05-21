class Solution {
    int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(int[][]grid,int m, int n, int row, int col,boolean[][]visited){
        visited[row][col]=true;
        for(int[]d:dirs){
            int nr=row+d[0],nc=col+d[1];
            if(nr<0||nr>=m||nc<0||nc>=n)
                continue;
            if(visited[nr][nc]||grid[nr][nc]==1)
                continue;
            dfs(grid,m,n,nr,nc,visited);
        }

    }
    public int closedIsland(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==0 && !visited[i][0])
                dfs(grid,m,n,i,0,visited);
            if(grid[i][n-1]==0 && !visited[i][n-1])
                dfs(grid,m,n,i,n-1,visited);
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==0 && !visited[0][j])
                dfs(grid,m,n,0,j,visited);
            if(grid[m-1][j]==0 && !visited[m-1][j])
                dfs(grid,m,n,m-1,j,visited);
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    count++;
                    dfs(grid,m,n,i,j,visited);
                }
            }
        }
        return count;
    }
}