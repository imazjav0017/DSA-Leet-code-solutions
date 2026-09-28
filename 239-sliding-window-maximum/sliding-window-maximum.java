class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     Deque<Integer>deque=new ArrayDeque<>();
     int[]res=new int[nums.length-k+1];
     int idx=0;
     for(int right=0;right<nums.length;right++){
        // if elements at top of dq are not in range anymore remve it
        //for value right , left = right-k+1
        while(!deque.isEmpty() && deque.peekFirst()<right-k+1){
            deque.pollFirst();
        }
        while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[right]){
            deque.pollLast();
        }
        deque.offerLast(right);
        if(right>=k-1){
            res[idx++]=nums[deque.peekFirst()];
        }
     }
     return res;
    }
}