class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->Integer.compare(nums[b],nums[a]));
        int[]res=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            pq.offer(i);
        }
        res[0]=nums[pq.peek()];
        int idx=1;
        int left=1;
        for(int i=k;i<nums.length;i++){
            while(!pq.isEmpty() && pq.peek()<left){
                pq.poll();
            }
            pq.offer(i);
            res[idx++]=nums[pq.peek()];
            left++;
        }
        return res;
    }
}