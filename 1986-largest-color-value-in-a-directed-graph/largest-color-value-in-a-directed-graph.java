class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<Integer>[]graph=new ArrayList[n];
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[]e:edges){
            int from=e[0],to=e[1];
            graph[from].add(to);
            indegree[to]++;
        }
        int[][]dp=new int[n][26];
        Queue<Integer>q=new ArrayDeque<>();
        int processed=0,answer=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            processed++;
            int node=q.poll();
            int color=colors.charAt(node)-'a';
            dp[node][color]++;
            answer=Math.max(answer,dp[node][color]);
            for(int next:graph[node]){
                for(int c=0;c<26;c++){
                    dp[next][c]=Math.max(dp[next][c],dp[node][c]);
                }
                indegree[next]--;
                if(indegree[next]==0)
                    q.offer(next);
            }
        }
        if(processed!=n)return -1;
        return answer;
    }
}