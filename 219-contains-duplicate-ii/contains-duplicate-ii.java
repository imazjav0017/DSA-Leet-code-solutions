class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int n=nums.length;
        for (int right = 0; right < n; right++) {
            if (window.contains(nums[right])) {
                return true;
            }

            window.add(nums[right]);

            if (window.size() > k) {
                window.remove(nums[right - k]);
            }
        }

        return false;
    }
}