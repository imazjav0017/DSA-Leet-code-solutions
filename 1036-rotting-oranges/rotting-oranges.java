class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int fresh=0,time=0;
        Queue<int[]>queue=new ArrayDeque();
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        while(!queue.isEmpty() && fresh>0){
            int n=queue.size();
            for(int i=0;i<n;i++){
                int[]x=queue.poll();
                int r=x[0],c=x[1];
                for(int[]dir:dirs){
                int dr=dir[0],dc=dir[1];
                int nr=dr+r,nc=dc+c;
                if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1)
                {
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc]=2;
                    fresh--;
                }
            }
            }
            time++;
        }
        return fresh>0?-1:time;
    }
}