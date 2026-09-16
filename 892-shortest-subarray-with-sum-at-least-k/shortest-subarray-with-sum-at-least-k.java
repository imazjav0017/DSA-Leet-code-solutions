class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int minLen=n+1;
        Deque<Integer>dq=new ArrayDeque<>();
        long[]prefix=new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int i=0;i<=n;i++){
            while(!dq.isEmpty() && prefix[i]-prefix[dq.peekFirst()]>=k){
                minLen=Math.min(minLen,i-dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[i]<=prefix[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return minLen==n+1?-1:minLen;
    }
}