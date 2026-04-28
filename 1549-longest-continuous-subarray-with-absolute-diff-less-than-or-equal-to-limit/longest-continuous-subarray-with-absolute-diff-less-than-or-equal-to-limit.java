class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>(); // decreasing
        Deque<Integer> minDeque = new ArrayDeque<>(); // increasing

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            while (!maxDeque.isEmpty() && maxDeque.peekLast() < num) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(num);

            while (!minDeque.isEmpty() && minDeque.peekLast() > num) {
                minDeque.pollLast();
            }
            minDeque.offerLast(num);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }

                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}