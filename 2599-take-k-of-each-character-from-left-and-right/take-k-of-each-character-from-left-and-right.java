class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        Map<Character,Integer>freq=new HashMap<>();
        freq.put('a',0);
        freq.put('b',0);
        freq.put('c',0);
        for(char c:s.toCharArray()){
            freq.put(c,freq.get(c)+1);
        }
        int aToRemove=freq.get('a')-k;
        int bToRemove=freq.get('b')-k;
        int cToRemove=freq.get('c')-k;
        if(aToRemove<0 ||bToRemove<0 ||cToRemove<0)
            return -1;
        int maxLen=0;
        int left=0,right=0;
        Map<Character,Integer>windowMap=new HashMap<>();
        windowMap.put('a',0);
        windowMap.put('b',0);
        windowMap.put('c',0);
        while(right<n){
            char c=s.charAt(right);
            windowMap.put(c,windowMap.get(c)+1);
            while(left<n && (windowMap.get('a')>aToRemove 
            ||windowMap.get('b')>bToRemove || windowMap.get('c')>cToRemove)){
                char cl=s.charAt(left);
                windowMap.put(cl,windowMap.get(cl)-1);
                left++;
            }
            if(right<left){
                right=left;
            }
            else{
                maxLen=Math.max(maxLen,right-left+1);
                right++;
            }
        }
        return n-maxLen;
    }
}