class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        Deque<Integer>stack=new ArrayDeque<>();
        long minSum=0,maxSum=0;
        for(int i=0;i<=n;i++){
            int value=i==n?Integer.MIN_VALUE:nums[i];
            while(!stack.isEmpty() && value<nums[stack.peek()]){
                int idx=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek();
                int right=i;
                long leftChoices=idx-left;
                long rightChoices=right-idx;
                long contributions=leftChoices*rightChoices*nums[idx];
                minSum+=contributions;
            }
            if(i<n){
                stack.push(i);
            }
        }
        for(int i=0;i<=n;i++){
            int value=i==n?Integer.MAX_VALUE:nums[i];
            while(!stack.isEmpty() && value>nums[stack.peek()]){
                int idx=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek();
                int right=i;
                long leftChoices=idx-left;
                long rightChoices=right-idx;
                long contributions=leftChoices*rightChoices*nums[idx];
                maxSum+=contributions;
            }
            if(i<n)
                stack.push(i);
        }
        return maxSum-minSum;
    }
}