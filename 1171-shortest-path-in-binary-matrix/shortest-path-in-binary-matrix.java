class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 ||grid[n-1][n-1]==1)
            return -1;
        Queue<int[]>q=new ArrayDeque<>();
        int[][]dirs={{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,0},{1,0},{-1,-1}};
        int steps=1;
        boolean[][]visited=new boolean[n][n];
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int[]rc=q.poll();
                int r=rc[0],c=rc[1];
                if(r==n-1 && c==n-1)
                    return steps;
                for(int[]dir:dirs){
                    int nr=r+dir[0],nc=c+dir[1];
                    if(nr<0||nc<0||nr>=n||nc>=n||visited[nr][nc]||grid[nr][nc]==1)
                        continue;
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
            steps++;
        }
        return -1;
    }
}