class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges=0;
        int m=grid.length,n=grid[0].length;
        Queue<int[]>q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) freshOranges++;
                else if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][]dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int min=0;
        while(!q.isEmpty() && freshOranges>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                int[]node=q.poll();
                for(int[]dir:dirs){
                    int nr=node[0]+dir[0],nc=node[1]+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        freshOranges--;
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            min++;
        }
        return freshOranges>0?-1:min;
    }
}