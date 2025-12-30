class Solution {
    public int numTrees(int n) {
        List<Integer> numTree=new ArrayList<>();
        for(int i=0;i<=n;i++){
            numTree.add(1);
        }
        for(int nodes=2;nodes<=n;nodes++){
            int total=0;
            for(int root=1;root<=nodes;root++){
                int left=root-1;
                int right=nodes-root;
                total+=numTree.get(left)*numTree.get(right);
            }
            numTree.set(nodes,total);
        }
        return numTree.get(n);
    }
}