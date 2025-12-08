class Solution {
    /* nklog k sort each element
    for each :
    original string;
        sort str[i];//klog k
        add to hashmap()
    */
    public List<List<String>> groupAnagrams(String[] strs) {
       int n= strs.length;
       List<List<String>>res=new ArrayList<>();
       Map<String,List<String>> map= new HashMap<>();
       for(int i=0;i<n;i++){
        String s= strs[i];
        char []arr=s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        List<String> x= map.getOrDefault(sorted,new ArrayList<String>());
        x.add(s);
        map.put(sorted,x);
       }
       map.forEach((key,value)->{
        res.add(value);
       });
       return res;
    }
}