class Solution {
    public int dfs(int[][]grid,int r,int c,boolean[][]visited){
        if(r<0 ||c<0||r>=grid.length||c>=grid[0].length||visited[r][c] ||grid[r][c]==0)
            return 0;
        visited[r][c]=true;
        return 1+dfs(grid,r+1,c,visited)+dfs(grid,r-1,c,visited)+dfs(grid,r,c+1,visited)
        +dfs(grid,r,c-1,visited);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        boolean[][]visited=new boolean[rows][cols];
        int area=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    area=Math.max(area,dfs(grid,i,j,visited));
                }
            }
        }
        return area;
    }
}