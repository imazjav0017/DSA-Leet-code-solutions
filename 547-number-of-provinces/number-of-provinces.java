class Solution {
    void dfs(int node, List<Integer>[]graph,boolean[]visited){
        visited[node]=true;
        for(int child:graph[node]){
            if(!visited[child]){
                dfs(child,graph,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                if(isConnected[i][j]==1){
                    graph[i].add(j);
                }
            }
        }
        boolean[]visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,graph,visited);
            }
        }
        return count;
    }
}