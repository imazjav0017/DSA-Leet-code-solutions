class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer>map=new HashMap<>();
        int l=0;
        int res=0;
        int maxF=0;
        for(int r=0;r<s.length();r++){
            int count=map.getOrDefault(s.charAt(r),0)+1;
            map.put(s.charAt(r),count);
            if(maxF<count) maxF=count;
            while((r-l+1)-maxF>k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            if(res<(r-l+1)){
                res=r-l+1;
            }
        }
        return res;
    }
}