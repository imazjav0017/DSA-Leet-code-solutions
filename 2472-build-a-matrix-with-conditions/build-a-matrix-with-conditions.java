class Solution {
    List<Integer>topoSort(int k,int[][]conditions){
        List<Integer>graph[]=new ArrayList[k+1];
        int[]indegree=new int[k+1];
        for(int i=1;i<=k;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[]c:conditions){
            int b=c[0],a=c[1];
            graph[b].add(a);
            indegree[a]++;
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=1;i<=k;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        List<Integer>order=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            order.add(node);
            for(int next:graph[node]){
                indegree[next]--;
                if(indegree[next]==0)
                    q.offer(next);
            }
        }
        return order;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>rowOrder=topoSort(k,rowConditions);
        List<Integer>colOrder=topoSort(k,colConditions);
        if(rowOrder.size()!=k || colOrder.size()!=k)
            return new int[0][0];
        int[]rowPos=new int[k+1];
        int[]colPos=new int[k+1];
        for(int i=0;i<k;i++){
            rowPos[rowOrder.get(i)]=i;
            colPos[colOrder.get(i)]=i;
        }
        int[][]matrix=new int[k][k];
        for(int num=1;num<=k;num++){
            int r=rowPos[num],c=colPos[num];
            matrix[r][c]=num;
        }
        return matrix;
    }
}