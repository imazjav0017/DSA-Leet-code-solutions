class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     int n=nums.length;
     int[]res=new int[n-(k-1)];
     Deque<Integer>deque=new ArrayDeque<>();
     int right=0;
     while(right<n){
        while(!deque.isEmpty() && deque.peekFirst()<=right-k){
            deque.pollFirst();
        }
        while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[right]){
            deque.pollLast();
        }
        deque.offerLast(right);
        if((right-k)+1>=0){
            res[(right-k)+1]=nums[deque.peekFirst()];
        }
        right++;
     }
     return res;   
    }
}