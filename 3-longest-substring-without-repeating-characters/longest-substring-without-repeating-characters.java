class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n<2) return n;
        int left=0;
        Set<Character>set=new HashSet<>();
        int max=1;
        set.add(s.charAt(left));
        for(int right=1;right<n;right++){
            while(left<right && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}