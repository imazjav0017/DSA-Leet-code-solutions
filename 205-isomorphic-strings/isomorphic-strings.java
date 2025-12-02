class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>map1=new HashMap<>();
        Map<Character,Boolean>map2=new HashMap<>();
        char[]arr=s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i++){
            char s1=s.charAt(i);
            char t1=t.charAt(i);
            if(map1.containsKey(s1)){
                arr[i]=map1.get(s1);
            }
            else if(map2.containsKey(t1))
            {
                return false;
            }
            else
            {
                map1.put(s1,t1);
                map2.put(t1,true);
                arr[i]=t1;
            }
        }
        String res=new String(arr);
        System.out.println(res);
        return res.equals(t);
    }
}