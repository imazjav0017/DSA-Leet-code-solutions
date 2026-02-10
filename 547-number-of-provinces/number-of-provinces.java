class Solution {
    HashSet<Integer>visited=new HashSet<Integer>();
    public void bfs(int row,int rows, int cols, int[][]isConnected){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<cols;i++){
            if(i==row)
                continue;
            if(isConnected[row][i]==1){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int x=q.poll();
            visited.add(x);
            for(int i=0;i<cols;i++){
                if(isConnected[x][i]==1 && !visited.contains(i)){
                    q.add(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int rows=isConnected.length,cols=isConnected[0].length;
        int res=0;
        for(int i=0;i<rows;i++){
            if(!visited.contains(i)){
                res++;
                bfs(i,rows,cols,isConnected);
                visited.add(i);
            }
        }
        return res;
    }
}