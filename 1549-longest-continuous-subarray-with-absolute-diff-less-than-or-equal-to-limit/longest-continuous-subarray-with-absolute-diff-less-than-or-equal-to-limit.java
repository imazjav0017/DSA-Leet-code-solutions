class Solution {
    public int longestSubarray(int[] nums, int limit) {
       int n=nums.length;
       Deque<Integer>maxDequeue=new ArrayDeque<>();
       Deque<Integer>minDequeue=new ArrayDeque<>();
       int left=0,right=0;
       int maxLen=0;
       while(right<n){
        int num=nums[right];
        while(!maxDequeue.isEmpty() && maxDequeue.peekLast()<num){
            maxDequeue.pollLast();
        }
        maxDequeue.offerLast(num);
        while(!minDequeue.isEmpty() && minDequeue.peekLast()>num){
            minDequeue.pollLast();
        }
        minDequeue.offerLast(num);
        while(maxDequeue.peekFirst()-minDequeue.peekFirst()>limit){
            if(nums[left]==maxDequeue.peekFirst()){
                maxDequeue.pollFirst();
            }
             if(nums[left]==minDequeue.peekFirst()){
                minDequeue.pollFirst();
            }
            left++;
        }
        int len=right-left+1;
        maxLen=Math.max(len,maxLen);
        right++;
       }
       return maxLen;
    }
}