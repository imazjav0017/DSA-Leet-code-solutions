class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[]graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        int[]indegree=new int[numCourses];
        for(int[]pq:prerequisites){
            int from=pq[1],to=pq[0];
            indegree[to]++;
            graph[from].add(to);
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        int processedNodes=0;
        int[]res=new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.poll();
            res[idx++]=node;
            processedNodes++;
            for(int ne:graph[node]){
                indegree[ne]--;
                if(indegree[ne]==0)
                    q.offer(ne);
            }
        }
        return processedNodes==numCourses?res:new int[0];
    }
}