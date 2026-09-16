class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,current,res);
        return res;
    }
    void backtrack(int[]nums,int start,List<Integer>current,List<List<Integer>>res){
        res.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            backtrack(nums,i+1,current,res);
            current.remove(current.size()-1);
        }
    }
}