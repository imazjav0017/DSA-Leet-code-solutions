class Solution {
    int find(int x,int[]parent){
        if(x!=parent[x]){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
    void union(int a, int b, int[]parent,int[]rank){
        int pa=find(a,parent),pb=find(b,parent);
        if(pa==pb) return;
        if(rank[pa]<rank[pb])
            parent[pa]=pb;
        else if(rank[pa]>rank[pb])
            parent[pb]=pa;
        else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int[]parent=new int[n];
        int[]rank=new int[n];
        Map<Integer,Integer>rowMap=new HashMap<>();
        Map<Integer,Integer>colMap=new HashMap<>();
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            int r=stones[i][0],c=stones[i][1];
            if(rowMap.containsKey(r)){
                union(rowMap.get(r),i,parent,rank);
            }else{
                rowMap.put(r,i);
            }
            if(colMap.containsKey(c)){
                union(colMap.get(c),i,parent,rank);
            }else{
                colMap.put(c,i);
            }
        }
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(find(i,parent));
        }
        return n-set.size();
    }
}