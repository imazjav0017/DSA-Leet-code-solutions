class Solution {
    private boolean dfs(Map<Integer,List<Integer>>adj,int c,List<Integer>res,boolean[]visited,
    boolean[]completed)
    {
        visited[c]=true;
        List<Integer>p=adj.get(c);
        if(p==null || p.size()==0){
            completed[c]=true;
            res.add(c);
            return true;
        }
        for(int prc:p){
            if(visited[prc] && !completed[prc]){
                return false;
            }
            else if(!completed[prc] && !visited[prc]){
                boolean isValid=dfs(adj,prc,res,visited,completed);
                if(!isValid)
                    return false;
                if(!completed[prc]){
                    completed[prc]=true;
                    res.add(prc);
                }
            }
        }
        if(!completed[c]){
            completed[c]=true;
            res.add(c);
        }
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        Map<Integer,List<Integer>>adj=new HashMap<>();
        for(int[]pr:prerequisites){
            int i=pr[0],j=pr[1];
            List<Integer>p=adj.getOrDefault(i,new ArrayList<Integer>());
            p.add(j);
            adj.put(i,p);
        }
        List<Integer>res=new ArrayList<>();
        boolean[]visited=new boolean[numCourses];
        boolean[]completed=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && !dfs(adj,i,res,visited,completed))
            {
                return new int[0];
            }
        }
        int[]order=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            order[i]=res.get(i);
        }
        return order;
    }
}