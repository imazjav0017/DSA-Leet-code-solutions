class Solution {
    int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(int row, int col, char[][]grid, int m, int n, boolean[][]visited){
        visited[row][col]=true;
        for(int[]dir:dirs){
            int nr=row+dir[0],nc=col+dir[1];
            if(nr<0||nc<0||nr>=m||nc>=n||grid[nr][nc]=='0')
                continue;
            if(!visited[nr][nc])
                dfs(nr,nc,grid,m,n,visited);
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int count=0;
        boolean[][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,m,n,visited);
                }
            }
        }
        return count;
    }
}