class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);              // still room, just add
            } else if (num > heap.peek()) {    // num is bigger than smallest in heap
                heap.poll();                  // remove smallest
                heap.offer(num);              // add new bigger element
            }
            // else num <= smallest in heap -> ignore
        }
        return heap.poll();
    }
}