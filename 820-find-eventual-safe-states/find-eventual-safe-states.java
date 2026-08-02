class Solution {
    boolean dfs(
    int num,
    List<Integer>[] adj,
    boolean[] visited,
    boolean[] rec,
    boolean[] safeNodes,
    boolean[] unsafeNodes
) {
    if (safeNodes[num]) {
        return true;
    }

    if (unsafeNodes[num]) {
        return false;
    }

    if (rec[num]) {
        return false;
    }

    visited[num] = true;
    rec[num] = true;

    for (int child : adj[num]) {
        boolean isSafe = dfs(
            child,
            adj,
            visited,
            rec,
            safeNodes,
            unsafeNodes
        );

        if (!isSafe) {
            rec[num] = false;
            unsafeNodes[num] = true;
            return false;
        }
    }

    rec[num] = false;
    safeNodes[num] = true;

    return true;
}
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[]terminalNodes=new boolean[n];
        List<Integer>safeNodes=new ArrayList<>();
        boolean[]unsafeNodes=new boolean[n];
        List<Integer>adj[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int edge:graph[i]){
                adj[i].add(edge);
            }
            if(graph[i].length==0)
                terminalNodes[i]=true;
        }
        for(int i=0;i<n;i++){
            if(terminalNodes[i])
                safeNodes.add(i);
            else{
                boolean isSafe=dfs(i,adj,new boolean[n],new boolean[n],terminalNodes,unsafeNodes);
                if(isSafe){
                    safeNodes.add(i);
                }
            }
        }
        return safeNodes;
    }
}