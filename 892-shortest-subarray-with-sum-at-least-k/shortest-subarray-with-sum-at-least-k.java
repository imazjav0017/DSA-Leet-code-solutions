class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int ans=n+1;
        long[]prefix=new long[n+1];
        long sum=0;
        for(int i=0;i<n;i++){
            prefix[i]=sum;
            sum+=nums[i];
        }
        prefix[n]=sum;
        Deque<Integer>dq=new ArrayDeque<>();
        dq.offer(0);
        for(int i=0;i<=n;i++){
            while(!dq.isEmpty() && prefix[i]-prefix[dq.peekFirst()]>=k){
                ans=Math.min(ans,i-dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[dq.peekLast()]>=prefix[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return ans==n+1?-1:ans;
    }
}