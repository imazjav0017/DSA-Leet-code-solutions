class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    void dfs(int[][]heights,int row,int col,boolean[][]visited){
        int m=heights.length,n=heights[0].length;
        visited[row][col]=true;
        for(int[]d:dirs){
            int nr=row+d[0],nc=col+d[1];
            if(nr<0 ||nr>=m || nc<0||nc>=n)
                continue;
            if(visited[nr][nc])
                continue;
            if(heights[nr][nc]>=heights[row][col])
                dfs(heights,nr,nc,visited);
        }
    }
   

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
            dfs(heights,i,n-1,atlantic);
        }
        for(int i=0;i<n;i++){
            dfs(heights,0,i,pacific);
            dfs(heights,m-1,i,atlantic);
        }
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
}