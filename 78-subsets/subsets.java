class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        backtrack(nums,0,current,res);
        return res;
    }
    void backtrack(int[]nums,int start,List<Integer>current,List<List<Integer>>res){
        res.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums,i+1,current,res);
            current.remove(current.size()-1);
        }
    }
}