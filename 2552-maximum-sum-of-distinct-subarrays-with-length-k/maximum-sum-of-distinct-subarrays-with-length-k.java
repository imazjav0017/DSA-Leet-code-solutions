class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long maxSum = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 > k) {
                int leftVal = nums[left];

                sum -= leftVal;
                map.put(leftVal, map.get(leftVal) - 1);

                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }

                left++;
            }

            if (right - left + 1 == k && map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}