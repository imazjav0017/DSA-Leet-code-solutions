class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[]count=new int[26];
        int left=0,max=0,maxCount=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            count[ch-'A']++;
            maxCount=Math.max(maxCount,count[ch-'A']);
            while(left<right && maxCount+k<(right-left+1)){
                count[s.charAt(left)-'A']--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}