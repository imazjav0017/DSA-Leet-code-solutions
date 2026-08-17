class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int[][]dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0,0});
        int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            int effort=curr[0],r=curr[1],c=curr[2];
            if(effort>dist[r][c])
                continue;
            if(r==m-1 && c==n-1)
                return effort;
            for(int[]dir:dirs){
                int nr=r+dir[0],nc=c+dir[1];
                if(nr<0||nc<0||nr>=m||nc>=n)
                    continue;
                int edgeEffort=Math.abs(heights[r][c]-heights[nr][nc]);
                int newEffort=Math.max(effort,edgeEffort);
                if(newEffort<dist[nr][nc]){
                    dist[nr][nc]=newEffort;
                    pq.offer(new int[]{newEffort,nr,nc});
                }
                
            }
        }
        return 0;
    }
}