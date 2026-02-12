class Solution {
    private boolean dfs(Map<Integer,List<Integer>>adj,int c,boolean[]visited,
    boolean[]completed,int n){
        List<Integer>p=adj.get(c);
        visited[c]=true;
        System.out.println(c+"____________");
        if(p.size()==0)
        {
            completed[c]=true;
            return true;
        }
        for(int p1:p){
            System.out.println("V:"+p1+"--"+visited[p1]+"--"+completed[p1]);
            if(visited[p1] &&!completed[p1])
                return false;
            else if(!visited[p1]){
                boolean x= dfs(adj,p1,visited,completed,n);
                if(x==false)
                    return false;
                else completed[p1]=true;
            }
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;
        Map<Integer,List<Integer>>adj=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            List<Integer>list=new ArrayList<>();
            adj.put(i,list);
        }
        int m=prerequisites.length,n=prerequisites[0].length;
        for(int i=0;i<m;i++){
            List<Integer>p=adj.get(prerequisites[i][0]);
            p.add(prerequisites[i][1]);
        }
        boolean[]visited=new boolean[numCourses];
        boolean[]completed=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                completed[i]=dfs(adj,i,visited,completed,numCourses);
                System.out.println("I:"+i+" v="+completed[i]);
                if(completed[i]==false)
                    return false;
            }
        }
        return true; 
    }
}