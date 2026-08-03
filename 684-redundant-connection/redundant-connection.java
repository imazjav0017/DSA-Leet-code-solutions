class Solution {
    int find(int x,int[]parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
    boolean union(int a,int b, int[]parent,int[]rank){
        int pa=find(a,parent), pb=find(b,parent);
        if(pa==pb)
            return false;
        if(rank[pa]<rank[pb])
            parent[pa]=pb;
        else if(rank[pa]>rank[pb])
            parent[pb]=pa;
        else{
            parent[pa]=pb;
            rank[pa]++;
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[]parent=new int[n+1];
        int[]rank=new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        int[]last=new int[2];
        for(int[]e:edges){
            if(!union(e[0],e[1],parent,rank)){
                last[0]=e[0];
                last[1]=e[1];
            }
        }
        return last;
    }
}