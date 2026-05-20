class Solution {
    int dfs(int[][]grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        if(row<0||col<0||row>=m||col>=n||grid[row][col]==0)
            return 0;
        int count=1;
        grid[row][col]=0;
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[]d:dirs){
            int nr=row+d[0],nc=col+d[1];
            count+=dfs(grid,nr,nc);
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int count=dfs(grid,i,j);
                    max=Math.max(count,max);
                }
            }
        }
        return max;
    }
}