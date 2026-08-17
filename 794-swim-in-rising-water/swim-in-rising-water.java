class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][]dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0],0,0});
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            int time=curr[0],r=curr[1],c=curr[2];
            if(time>dist[r][c])
                continue;
            if(r==n-1 && c==n-1)
                return time;
            for(int[]dir:dirs){
                int nr=r+dir[0],nc=c+dir[1];
                if(nr<0||nc<0||nr>=n||nc>=n)
                    continue;
                int timeNeeded=Math.max(time,grid[nr][nc]);
                if(timeNeeded<dist[nr][nc]){
                    dist[nr][nc]=timeNeeded;
                    pq.offer(new int[]{timeNeeded,nr,nc});
                }
            }
        }
        return 0;
    }
}