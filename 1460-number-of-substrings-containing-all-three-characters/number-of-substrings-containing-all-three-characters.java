class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        long kSum=(1L* n *(n+1))/2;
        long sum=0;
        Map<Character,Long>map=new HashMap<>();
        int left=0,right=0;
        while(right<n){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0L)+1);
            while(map.size()>2){
                char cl=s.charAt(left);
                map.put(cl,(long)map.getOrDefault(cl,0L)-1);
                if(map.get(cl)==0){
                    map.remove(cl);
                }
                left++;
            }
            sum+=right-left+1;
            right++;
        }
        return (int)(kSum-sum);

    }
}