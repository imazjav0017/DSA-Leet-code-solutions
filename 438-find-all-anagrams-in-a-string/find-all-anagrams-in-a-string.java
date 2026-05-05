class Solution {
    boolean isValid(Map<Character,Integer>targetMap,Map<Character,Integer>sourceMap){
        for(char c: targetMap.keySet()){
            int c1=targetMap.get(c);
            int c2=sourceMap.getOrDefault(c,0);
            if(c1!=c2)
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int m=s.length();
        int n=p.length();
        List<Integer>res=new ArrayList<>();
        if(m<n)
            return res;
        Map<Character,Integer>targetMap=new HashMap<>();
        for(char c:p.toCharArray()){
            targetMap.put(c,targetMap.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        Map<Character,Integer>sourceMap=new HashMap<>();
        for(int i=0;i<n;i++){
            sourceMap.put(s.charAt(i),sourceMap.getOrDefault(s.charAt(i),0)+1);
        }
        if(isValid(targetMap,sourceMap))
            res.add(0);
        for(int i=n;i<m;i++){
            char c=s.charAt(i);
            sourceMap.put(c,sourceMap.getOrDefault(c,0)+1);
            char cl=s.charAt(i-n);
            sourceMap.put(cl,sourceMap.getOrDefault(cl,0)-1);
            if(isValid(targetMap,sourceMap))
                res.add(i-n+1);
        }
        return res;

    }
}