class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[][]res=new int[m][n];
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
                else{
                    res[i][j]=-1;
                }
            }
        }
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int d=1;
        while(!queue.isEmpty()){
            int s=queue.size();
            for(int i=0;i<s;i++){
                int[]point=queue.poll();
                int r=point[0],c=point[1];
                for(int[]dir:dirs){
                    int nr=r+dir[0],nc=c+dir[1];
                    if(nr<0||nr>=m||nc<0||nc>=n)
                        continue;
                    if(mat[nr][nc]==1 && res[nr][nc]==-1){
                        queue.offer(new int[]{nr,nc});
                        res[nr][nc]=d;
                    }
                }
            }
            d++;
        }
        return res;
    }
}