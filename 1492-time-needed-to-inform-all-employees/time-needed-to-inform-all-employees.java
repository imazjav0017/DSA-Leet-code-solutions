class Solution {
    int dfs(int root,Map<Integer,List<Integer>>map,int[]informTime){
        if(root==-1)
            return 0;
        int maxTime=0;
        if(map.containsKey(root)){
            for(int i:map.get(root)){
                maxTime=Math.max(maxTime,dfs(i,map,informTime));
            }
        }
        return informTime[root]+maxTime;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
            return informTime[0];
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(manager[i]==-1)
                continue;
            List<Integer>list=map.getOrDefault(manager[i],new ArrayList<>());
            list.add(i);
            map.put(manager[i],list);
        }
        return dfs(headID,map,informTime);
    }
}