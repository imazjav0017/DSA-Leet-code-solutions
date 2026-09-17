class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        boolean[]used=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,path,res,used);
        return res;
    }
    void backtrack(int[]nums,List<Integer>path,List<List<Integer>> res, boolean[]used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])
                continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            used[i]=true;
            path.add(nums[i]);
            backtrack(nums,path,res,used);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }

}