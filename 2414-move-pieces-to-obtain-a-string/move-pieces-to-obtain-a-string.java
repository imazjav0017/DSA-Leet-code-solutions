class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {

            // skip blanks in start
            while (i < n && start.charAt(i) == '_') i++;

            // skip blanks in target
            while (j < n && target.charAt(j) == '_') j++;

            // both finished
            if (i == n && j == n) return true;

            // one finished early
            if (i == n || j == n) return false;

            char a = start.charAt(i);
            char b = target.charAt(j);

            // pieces must match
            if (a != b) return false;

            // L cannot move right
            if (a == 'L' && i < j) return false;

            // R cannot move left
            if (a == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }
}