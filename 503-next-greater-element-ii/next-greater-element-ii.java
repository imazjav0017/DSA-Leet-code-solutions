class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]res=new int[n];
        Deque<Integer>stack=new ArrayDeque<>();
        Arrays.fill(res,-1);
        for(int i=0; i<2*n;i++){
            int idx=i%n;
            while(!stack.isEmpty() && nums[idx]>nums[stack.peek()]){
                int index=stack.pop();
                res[index]=nums[idx];
            }
            if(i<n)
                stack.push(idx);
        }
        return res;
    }
}