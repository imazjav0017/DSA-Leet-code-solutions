class Solution {
    void dfs(int node,List<Integer>[]graph,boolean[]visited){
        visited[node]=true;
        for(int child:graph[node]){
            if(!visited[child])
                dfs(child,graph,visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        List<Integer>[]graph= new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
       for(int i=0;i<n;i++){
        for(int room:rooms.get(i)){
            graph[i].add(room);
        }
       }
       boolean[]visited=new boolean[n];
       dfs(0,graph,visited);
       for(int i=0;i<n;i++){
        if(!visited[i])
            return false;
       }
       return true; 
    }
}