class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer>InDegree=new HashMap<>();
        List<Integer>[]graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            InDegree.put(i,0);
            graph[i]=new ArrayList<>();
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int[]p:prerequisites){
            InDegree.put(p[0],InDegree.get(p[0])+1);
            graph[p[1]].add(p[0]);
        }
        boolean[]visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(InDegree.get(i)==0){
                q.offer(i);
                visited[i]=true;
            }
        }
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int course=q.poll();
                List<Integer>dependents=graph[course];
                for(int c:dependents){
                    if(!visited[c]){
                        InDegree.put(c,InDegree.get(c)-1);
                        if(InDegree.get(c)==0){
                            q.offer(c);
                            visited[c]=true;
                        }
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(InDegree.get(i)!=0)
                return false;
        }
        return true;
    }
}