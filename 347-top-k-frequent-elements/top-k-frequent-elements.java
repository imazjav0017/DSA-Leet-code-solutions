class Solution {
   /**
   First build a frequency map for all numbers.
Use a min-heap (priority queue) where each entry stores the number and its frequency.
Push each number into the heap. If the heap grows beyond k, remove the smallest frequency.
After processing everything, the heap contains the k most frequent elements.
Extract them into the answer array.
 */
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer, Integer> freq = new HashMap<>();
        // for (int n : nums) {
        //     freq.put(n, freq.getOrDefault(n, 0) + 1);
        // }

        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a, b) -> a[1] - b[1]     // min heap by frequency
        // );

        // for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
        //     pq.offer(new int[]{e.getKey(), e.getValue()});
        //     if (pq.size() > k) pq.poll();
        // }

        // int[] ans = new int[k];
        // for (int i = k - 1; i >= 0; i--) {
        //     ans[i] = pq.poll()[0];
        // }

        // return ans;
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();  // num : freq
        List<List<Integer>> buckets = new ArrayList<>();  // freq : [num1, num2...]
        
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets.get(freq).add(num);
        }
        
        int[] result = new int[k];
        int idx = 0;
        for (int i = n; i >= 0 && idx < k; i--) {
            for (int num : buckets.get(i)) {
                result[idx++] = num;
                if (idx >= k) break;
            }
        }
        
        return result;
    }
}