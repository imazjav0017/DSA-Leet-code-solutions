class Solution {
    public void dfs(char[][]grid,boolean[][]v,int r,int c,int rows,int cols){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]=='0'||v[r][c])
            return;
        v[r][c]=true;
        dfs(grid,v,r+1,c,rows,cols);
        dfs(grid,v,r-1,c,rows,cols);
        dfs(grid,v,r,c+1,rows,cols);
        dfs(grid,v,r,c-1,rows,cols);
        return;
    }
    public int numIslands(char[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int res=0;
        boolean[][]v=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!v[i][j] && grid[i][j]=='1'){
                    res+=1;
                    dfs(grid,v,i,j,rows,cols);
                }
            }
        }
        return res;
    }
}