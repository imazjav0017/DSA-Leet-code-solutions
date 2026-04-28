class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[]count=new int[26];
        int left=0,right=0;
        int maxLen=0,maxCount=0;
        while(right<n){
            char c=s.charAt(right);
            count[c-'A']++;
            for(int i=0;i<26;i++){
                maxCount=Math.max(maxCount,count[i]);
            }
            int len=right-left+1;
            while(len-maxCount>k){
                char cl=s.charAt(left);
                count[cl-'A']--;
                for(int i=0;i<26;i++){
                maxCount=Math.max(maxCount,count[i]);
                }
                left++;
                len=right-left+1;
            }
            maxLen=Math.max(len,maxLen);
            right++;
        }
        return maxLen;
    }
}