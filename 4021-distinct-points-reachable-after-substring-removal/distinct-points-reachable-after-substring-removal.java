class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        HashSet<String> hs = new HashSet<>();

        int x = 0, y = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'U')
                y++;
            else if (ch == 'D')
                y--;
            else if (ch == 'L')
                x--;
            else if (ch == 'R')
                x++;
        }

        int[] dx = new int[n];
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            dx[i] = i > 0 ? dx[i-1] : 0;
            dy[i] = i > 0 ? dy[i-1] : 0;
            char ch = s.charAt(i);
            if (ch == 'U')
                dy[i]++;
            else if (ch == 'D')
                dy[i]--;
            else if (ch == 'L')
                dx[i]--;
            else if (ch == 'R')
                dx[i]++;
        }

        for (int i = 0; i <= n - k; i++) {
            int pre_x = i > 0 ? dx[i - 1] : 0;
            int pre_y = i > 0 ? dy[i - 1] : 0;

            int subs_x = dx[i + k - 1] - pre_x;
            int subs_y = dy[i + k - 1] - pre_y;
            
            int xi = x - subs_x;
            int yi = y - subs_y;
            hs.add(xi + "," + yi);
        }

        return hs.size();
    }
}