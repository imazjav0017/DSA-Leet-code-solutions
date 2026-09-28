class Solution {
    public String minWindow(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        if (n2 > n1)
            return "";

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            char ch = t.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int need = target.size();
        int have = 0;
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < n1; right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (target.containsKey(ch) &&
                window.get(ch).equals(target.get(ch))) {
                have++;
            }

            while (have == need) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char l = s.charAt(left);

                window.put(l, window.get(l) - 1);

                if (target.containsKey(l) &&
                    window.get(l) < target.get(l)) {
                    have--;
                }

                if (window.get(l) <= 0) {
                    window.remove(l);
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}