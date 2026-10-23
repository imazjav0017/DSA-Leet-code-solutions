class Solution {
    public long maxEarnings(int[][] meetings) {
        Arrays.sort(meetings, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int n = meetings.length;
        int[] ends = new int[n];
        long[] best = new long[n];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            int revenue = meetings[i][2];

            ends[i] = end;

            // Find last meeting with end <= start
            int left = 0, right = i;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (ends[mid] <= start) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            int j = left - 1;

            // Option 1: select this meeting alone
            long curr = revenue;

            // Option 2: extend a previous selection
            if (j >= 0) {
                curr = Math.max(
                    curr,
                    revenue + (long) start + best[j]
                );
            }

            ans = Math.max(ans, curr);

            // best[i] = maximum dp[j] - end[j]
            // for all j <= i
            long value = curr - end;

            best[i] = (i == 0)
                ? value
                : Math.max(best[i - 1], value);
        }

        return ans;
    }
}
