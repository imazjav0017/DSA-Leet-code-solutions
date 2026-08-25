class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<k+1;i++){
            int[]temp=dist.clone();
            for(int[]flight:flights){
                int from=flight[0],to=flight[1],cost=flight[2];
                if(dist[from]!=Integer.MAX_VALUE && dist[from]+cost<temp[to]){
                    temp[to]=dist[from]+cost;
                }
            }
            dist=temp;
        }
        return dist[dst]!=Integer.MAX_VALUE?dist[dst]:-1;
    }
}