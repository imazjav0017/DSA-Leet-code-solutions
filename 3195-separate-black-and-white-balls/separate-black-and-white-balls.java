class Solution {
    public long minimumSteps(String s) {
        long res = 0;
        long ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                res += ones;
            }
        }

        return res;
    }
}