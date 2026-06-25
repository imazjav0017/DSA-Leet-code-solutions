class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[]indegree=new int[n+1];
        int[]finishTime=new int[n+1];
        List<Integer>[]graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[]r:relations){
            int prev=r[0],c=r[1];
            graph[prev].add(c);
            indegree[c]++;
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.offer(i);
                finishTime[i]=time[i-1];
            }
        }
        int answer=0;
        while(!q.isEmpty()){
            int c=q.poll();
            answer=Math.max(finishTime[c],answer);
            for(int next:graph[c]){
                finishTime[next]=Math.max(finishTime[c]+time[next-1],finishTime[next]);
                indegree[next]--;
                if(indegree[next]==0)
                    q.offer(next);
            }
        }
        return answer;
    }
}