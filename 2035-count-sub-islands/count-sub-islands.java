class Solution {
    int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    boolean dfs(int[][]grid1,int[][]grid2,int m, int n,int row,int col, boolean[][]visited){
        visited[row][col]=true;
        boolean isSubIsland=grid1[row][col]==1;
        for(int[]d:dirs){
            int nr=row+d[0],nc=col+d[1];
            if(nr<0||nr>=m||nc<0||nc>=n)
                continue;
            if(visited[nr][nc]||grid2[nr][nc]==0)
                continue;
            isSubIsland=dfs(grid1,grid2,m,n,nr,nc,visited) && isSubIsland;
        }
        return isSubIsland;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid1.length,n=grid1[0].length;
        boolean[][]visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && !visited[i][j]){
                    if(dfs(grid1,grid2,m,n,i,j,visited)){
                        count++;
                    }
                }
            }
        }
        return count;


    }
}