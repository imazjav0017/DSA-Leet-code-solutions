class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][]dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int[]edge:edges){
            int from=edge[0],to=edge[1],w=edge[2];
            dist[from][to]=Math.min(dist[from][to],w);
            dist[to][from]=Math.min(dist[from][to],w);
        }
        Set<Integer>[]counter=new HashSet[n];
        for(int i=0;i<n;i++){
            counter[i]=new HashSet<>();
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                        continue;
                    int newCost=dist[i][k]+dist[k][j];
                    if(newCost>distanceThreshold)
                        continue;
                    dist[i][j]=Math.min(dist[i][j],newCost);
                    counter[i].add(j);
                }
            }
        }
        int res=0,min=n+1;
        for(int i=0;i<n;i++){
            int count=counter[i].size();
            if(count<=min){
                min=count;
                res=i;
            }
        }
        return res;
    }
}