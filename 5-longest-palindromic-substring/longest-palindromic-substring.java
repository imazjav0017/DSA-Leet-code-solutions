class Solution {
    int lengthByExpandingCenter(int left,int right, String s, int n){
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1)
            return s;
        int maxLen=1,start=0;
        for(int center=0;center<n;center++){
            int len1=lengthByExpandingCenter(center,center,s,n);
            int len2=lengthByExpandingCenter(center,center+1,s,n);
            int len=Math.max(len1,len2);
            if(len>maxLen){
                maxLen=len;
                start=center-((len-1)/2);
            }
        }
        return s.substring(start,start+maxLen);
    }
}