class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        backtrack(k,1,n,path,res);
        return res;
    }
    void backtrack(int k, int start, int remaining, List<Integer>path, List<List<Integer>>res){
        if(remaining==0 && path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        if(remaining<0){
            return;
        }
        for(int i=start;i<=9;i++){
            path.add(i);
            backtrack(k,i+1,remaining-i,path,res);
            path.remove(path.size()-1);
        }
    }
}