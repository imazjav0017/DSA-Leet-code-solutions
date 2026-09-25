class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(String s:strs){
            char[]seq=s.toCharArray();
            Arrays.sort(seq);
            String sorted=new String(seq);
            List<String>list=map.getOrDefault(sorted,new ArrayList<>());
            list.add(s);
            map.put(sorted,list);
        }
        List<List<String>>res=new ArrayList<>();
        for(String s:map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}