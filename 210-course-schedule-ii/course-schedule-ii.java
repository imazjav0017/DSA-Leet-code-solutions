class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int[] indegree=new int[n];
        List<Integer>[]graph= new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[]p:prerequisites){
            int course=p[0];
            int pre=p[1];
            indegree[course]++;
            graph[pre].add(course);
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer>order=new ArrayList<>();
        int completed=0;
        while(!q.isEmpty()){
            completed++;
            int c=q.poll();
            order.add(c);
            for(int next:graph[c]){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        if(completed==n){
            int[]res=new int[n];
            for(int i=0;i<n;i++){
                res[i]=order.get(i);
            }
            return res;
        }else return new int[0];
    }
}