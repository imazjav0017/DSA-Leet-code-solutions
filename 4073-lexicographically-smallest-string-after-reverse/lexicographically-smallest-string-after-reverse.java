class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String smallest_s = s;

        for (int k = 1; k <= n; ++k) {
            // reverse prefix
            StringBuilder ptr = new StringBuilder(s.substring(0, k)).reverse();
            String spr = ptr.toString() + s.substring(k);
            if (spr.compareTo(smallest_s) < 0) {
                smallest_s = spr;
            }

            // reverse suffix
            StringBuilder strSuf = new StringBuilder(s.substring(n - k)).reverse();
            String ssr = s.substring(0, n - k) + strSuf.toString();
            if (ssr.compareTo(smallest_s) < 0) {
                smallest_s = ssr;
            }
        }

        return smallest_s;
    }
}