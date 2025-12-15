class Solution {
    public String findValidPair(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            int count=map.getOrDefault(s.charAt(i),0)+1;
            map.put(s.charAt(i),count);
        }
        
        for(int i=0;i<n-1;i++){
            char c1=s.charAt(i);
            char c2=s.charAt(i+1);
            if(c1==c2)continue;
            if(map.get(c1)==c1-'0' && map.get(c2)==c2-'0')
                return String.valueOf(""+c1+""+c2);
        }
        return "";
    }
}