class Solution {
    int findParent(int x, int[]parent){
        if(parent[x]!=x){
            parent[x]=findParent(parent[x],parent);
        }
        return parent[x];
    }
    void union(int a, int b, int[]parent, int[]rank){
        int pa=findParent(a,parent),pb=findParent(b,parent);
        if(pa==pb)
            return;
        if(rank[pa]<rank[pb])
            parent[pa]=pb;
        else if(rank[pa]>rank[pb])
            parent[pb]=pa;
        else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        int[]parent=new int[n];
        int[]rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Map<String,Integer> emailToKey=new HashMap<>();
        for(int i=0;i<n;i++){
            List<String>account=accounts.get(i);
            for(int j=1;j<account.size();j++){
                String email=account.get(j);
                if(emailToKey.containsKey(email)){
                    int prev=emailToKey.get(email);
                    union(i,prev,parent,rank);
                }else{
                    emailToKey.put(email,i);
                }
            }
        }
        Map<Integer,List<String>>groupedEmails=new HashMap<>();
        for(Map.Entry<String,Integer>entry:emailToKey.entrySet()){
            String email=entry.getKey();
            int index=entry.getValue();
            int root=findParent(index,parent);
            groupedEmails.computeIfAbsent(root,key->new ArrayList<>()).add(email);
        }
        List<List<String>>res=new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry:groupedEmails.entrySet()){
            int root=entry.getKey();
            List<String>emails=entry.getValue();
            Collections.sort(emails);
            List<String>merged=new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }
}