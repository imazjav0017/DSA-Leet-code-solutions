class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        int[]indegree=new int[n];
        for(int[]edge:edges){
            int from=edge[0],to=edge[1];
            indegree[to]++;
            graph[from].add(to);
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        //dp[node][color]= max count of color with path ending at node
        int[][]dp=new int[n][26];
        int processed=0,res=0;
        while(!q.isEmpty()){
            int from=q.poll();
            processed++;
            int colorAtNode=colors.charAt(from)-'a';
            dp[from][colorAtNode]+=1;
            for(int c=0;c<26;c++){
                res=Math.max(res,dp[from][c]);
            }
            for(int to: graph[from]){
                for(int c=0;c<26;c++){
                    dp[to][c]=Math.max(dp[to][c],dp[from][c]);
                }
                indegree[to]--;
                if(indegree[to]==0){
                    q.offer(to);
                }
            }
        }
        if(processed!=n)
            return -1;
        return res;
    }
}