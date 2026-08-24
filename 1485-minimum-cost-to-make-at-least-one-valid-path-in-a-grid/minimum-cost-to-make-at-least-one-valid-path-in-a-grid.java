class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][]dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        Deque<int[]>dq=new ArrayDeque<>();
        dq.offerFirst(new int[]{0,0,0});
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!dq.isEmpty()){
            int[]curr=dq.poll();
            int effort=curr[0],row=curr[1],col=curr[2];
            if(effort>dist[row][col]){
                continue;
            }
            if(row==m-1 && col==n-1)
                return effort;
            int[]zeroCostCell=new int[2];
            switch(grid[row][col]){
                case 1:
                    zeroCostCell=new int[]{row,col+1};
                    break;
                case 2:
                    zeroCostCell=new int[]{row,col-1};
                    break;
                case 3:
                    zeroCostCell=new int[]{row+1,col};
                    break;
                case 4:
                    zeroCostCell=new int[]{row-1,col};
                    break;
            }
            for(int[]dir:dirs){
                int nr=dir[0]+row,nc=col+dir[1];
                if(nr<0||nc<0||nr>=m||nc>=n)
                    continue;
                int edgeEffort=1;
                if(nr==zeroCostCell[0] && nc==zeroCostCell[1])
                    edgeEffort=0;
                if(dist[nr][nc]>edgeEffort+effort){
                    if(edgeEffort==0)
                        dq.offerFirst(new int[]{effort+edgeEffort,nr,nc});
                    else  dq.offerLast(new int[]{effort+edgeEffort,nr,nc});
                    dist[nr][nc]=effort+edgeEffort;
                }
            }
        }
        return 0;
    }
}