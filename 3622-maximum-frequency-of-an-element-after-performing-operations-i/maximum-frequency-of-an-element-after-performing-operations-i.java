class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 1;

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            int target = nums[i];

            while (left < n && nums[left] < target - k) {
                left++;
            }

            while (right < n && nums[right] <= target + k) {
                right++;
            }

            int reachable = right - left;
            int alreadyEqual = freq.get(target);
            int canChange = reachable - alreadyEqual;

            ans = Math.max(ans, alreadyEqual + Math.min(numOperations, canChange));
        }

        left = 0;

        for (right = 0; right < n; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }

            int windowSize = right - left + 1;
            ans = Math.max(ans, Math.min(numOperations, windowSize));
        }

        return ans;
    }
}