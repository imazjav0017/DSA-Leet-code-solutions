class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<int[]>q=new ArrayDeque<>();
        int freshOranges=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                if(grid[i][j]==1)
                    freshOranges++;
            }
        }
        int min=0;
        int[][]dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty() && freshOranges>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                int[]rc=q.poll();
                int r=rc[0],c=rc[1];
                for(int[]dir:dirs){
                    int nr=r+dir[0],nc=c+dir[1];
                    if(nr<0||nc<0||nr>=m||nc>=n||grid[nr][nc]!=1)
                        continue;
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr,nc});
                    freshOranges--;
                }
            }
            min++;
        }
        if(freshOranges>0)return -1;
        return min;
    }
}