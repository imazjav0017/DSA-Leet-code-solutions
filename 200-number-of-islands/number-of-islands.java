class Solution {
    int[][]dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(int r, int c, char[][]grid,boolean[][]visited){
        visited[r][c]=true;
        for(int[]dir:dirs){
            int nr=r+dir[0],nc=c+dir[1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length &&
            grid[nr][nc]=='1' && !visited[nr][nc]){
                dfs(nr,nc,grid,visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][]visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}