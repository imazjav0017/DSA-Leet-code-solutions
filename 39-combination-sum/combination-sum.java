class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        backtrack(candidates,0,path,res,target);
        return res;
    }
    void backtrack(int[]nums, int start, List<Integer>path, List<List<Integer>>res, int remaining){
        if(remaining==0){
            res.add(new ArrayList<>(path));
            return;
        }
        else if(remaining<0)
            return;
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,i,path,res,remaining-nums[i]);
            path.remove(path.size()-1);
        }
    }
}