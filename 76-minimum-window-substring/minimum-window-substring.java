class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(m > n) return "";
        int []hash = new int[128]; // to store chars freq
        int left = 0, minLen = Integer.MAX_VALUE, sIndex = -1;
        int count = 0;

        for(int i=0; i<m; i++) hash[t.charAt(i)]++;

        for(int right = 0; right < n; right++) {
            //check if char is preinserted 
            char ch = s.charAt(right);
            if(hash[ch] > 0) {
                count++;
            }
            hash[ch]--;

            // all t's char exists in s
            while(count == m) {
                // possible ans
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    sIndex = left;
                }

                // try shrinking
                char leftCh = s.charAt(left);
                hash[leftCh]++;
                if(hash[leftCh] > 0) count--; // if char freq becomes +ve means it doesnot exists
                left++;
            }
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}