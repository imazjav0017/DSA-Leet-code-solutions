class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      int n=numCourses;
      boolean[][]dist=new boolean[n][n];
      for(int[]req:prerequisites) {
        dist[req[0]][req[1]]=true;
      }
      for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(dist[i][j]||(dist[i][k] && dist[k][j]));
            }
        }
      }
     List<Boolean>res=new ArrayList<>();
      for(int[]query:queries){
        res.add(dist[query[0]][query[1]]);
      }
      return res;
    }
}