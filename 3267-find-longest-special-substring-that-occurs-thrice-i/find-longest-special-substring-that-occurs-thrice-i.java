class Solution {
    public int maximumLength(String s) {
        int n = s.length();

        int[][] count = new int[26][n + 1];

        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);
            int j = i;

            while (j < n && s.charAt(j) == ch) {
                j++;
            }

            int groupLen = j - i;
            int c = ch - 'a';

            for (int len = 1; len <= groupLen; len++) {
                count[c][len] += groupLen - len + 1;
            }

            i = j;
        }

        int ans = -1;

        for (int c = 0; c < 26; c++) {
            for (int len = 1; len <= n; len++) {
                if (count[c][len] >= 3) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}