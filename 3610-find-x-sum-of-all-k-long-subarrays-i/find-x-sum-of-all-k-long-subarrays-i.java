class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        int[] freq = new int[51]; // nums[i] <= 50

        // build first window
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }

        for (int start = 0; start <= n - k; start++) {
            ans[start] = getXSum(freq, x);

            // slide window
            if (start + k < n) {
                freq[nums[start]]--;
                freq[nums[start + k]]++;
            }
        }

        return ans;
    }

    private int getXSum(int[] freq, int x) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // lower freq worse
            return a[0] - b[0];                   // smaller value worse
        });

        for (int val = 1; val <= 50; val++) {
            if (freq[val] > 0) {
                minHeap.offer(new int[]{val, freq[val]});

                if (minHeap.size() > x) {
                    minHeap.poll();
                }
            }
        }

        int sum = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int val = curr[0];
            int count = curr[1];
            sum += val * count;
        }

        return sum;
    }
}