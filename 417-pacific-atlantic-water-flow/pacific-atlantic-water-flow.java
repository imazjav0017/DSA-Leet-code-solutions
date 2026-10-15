class Solution {
    int[][]dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(int r, int c, int[][]heights,boolean[][]visited){
        visited[r][c]=true;
        for(int[]dir:dirs){
            int nr=r+dir[0],nc=c+dir[1];
            if(nr<0 || nr>=heights.length ||nc<0 || nc>=heights[0].length || heights[nr][nc]<heights[r][c] || visited[nr][nc])
                continue;
            dfs(nr,nc,heights,visited);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        boolean[][]pacific=new boolean[m][n];
        boolean[][]atlantic=new boolean[m][n];
        for(int c=0;c<n;c++){
            dfs(0,c,heights,pacific);
            dfs(m-1,c,heights,atlantic);
        }
        for(int r=0;r<m;r++){
            dfs(r,0,heights,pacific);
            dfs(r,n-1,heights,atlantic);
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