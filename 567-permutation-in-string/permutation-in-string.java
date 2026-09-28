class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n2<n1)return false;
        int[]count=new int[26];
        int left=0;
        int[]window=new int[26];
        for(int i=0;i<n1;i++){
            count[s1.charAt(i)-'a']++;
            window[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(window,count))
            return true;
        for(int right=n1;right<n2;right++){
            window[s2.charAt(right)-'a']++;
            window[s2.charAt(left)-'a']--;
            left++;
            if(Arrays.equals(count,window))
                return true;
        }
        return false;
    }
}