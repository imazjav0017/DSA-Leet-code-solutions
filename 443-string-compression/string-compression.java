class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int read = 0;
        int write = 0;

        while (read < n) {
            char curr = chars[read];
            int count = 0;

            while (read < n && chars[read] == curr) {
                read++;
                count++;
            }

            chars[write++] = curr;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}