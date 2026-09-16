class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        backtrack(n,k,1,current,res);
        return res;
    }
    void backtrack(int n,int k, int start, List<Integer>current,List<List<Integer>>res){
        if(current.size()==k)
            res.add(new ArrayList<>(current));
        for(int i=start;i<=n;i++){
            current.add(i);
            backtrack(n,k,i+1,current,res);
            current.remove(current.size()-1);
        }
    }
}