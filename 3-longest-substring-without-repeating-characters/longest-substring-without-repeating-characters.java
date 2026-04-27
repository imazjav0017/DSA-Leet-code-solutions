class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1)
            return n;
        int left=0,right=0;
        Set<Character>set=new HashSet<>();
        int maxLen=0;
        while(right<n){
            char c=s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                int len=right-left+1;
                maxLen=Math.max(len,maxLen);
                right++;
            }
            else{
                while(left<right && set.contains(c)){
                    char cl=s.charAt(left);
                    //System.out.println(cl);
                    set.remove(cl);
                    left++;
                }
            }
        }
        return maxLen;

    }
}