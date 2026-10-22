class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            Set<Long> seen = new HashSet<>();

            for (int j = i; j < n; j++) {
                sum += nums[j];

                // Store what negating nums[j] would subtract
                seen.add(Math.floorMod(2L * nums[j], (long) k));

                long remainder = Math.floorMod(sum, (long) k);

                if (remainder == 0 || seen.contains(remainder)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}