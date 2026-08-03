class Solution {
    int findParent(int x,int[]parent){
        if(parent[x]!=x){
            parent[x]=findParent(parent[x],parent);
        }
        return parent[x];
    }
    boolean union(int a,int b, int[]parent,int[]rank){
        int pa=findParent(a,parent),pb=findParent(b,parent);
        if(pa==pb)
            return false;
        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }
        else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }
        else{
            parent[pb]=pa;
            rank[pa]++;
        }
        return true;
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[]parents=new int[n];
        int[]ranks=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        int count=n;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isConnected[i][j]==1 && union(i,j,parents,ranks))
                    count--;
            }
        }
        return count;
    }
}