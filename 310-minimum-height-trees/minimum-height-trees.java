class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[]degrees=new int[n];
        List<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[]e:edges){
            degrees[e[1]]++;
            degrees[e[0]]++;
            graph[e[1]].add(e[0]);
            graph[e[0]].add(e[1]);
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(degrees[i]==1){
                q.offer(i);
            }
        }
        if(n<=2){
            List<Integer>res=new ArrayList<>();
            for(int i=0;i<n;i++){
                res.add(i);
            }
            return res;
        }
        int nodesLeft=n;
        while(nodesLeft>2 && !q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                nodesLeft--;
                int node=q.poll();
                for(int next:graph[node]){
                    degrees[next]--;
                    if(degrees[next]==1)
                        q.offer(next);
                }
            }
        }
        List<Integer>res=new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}