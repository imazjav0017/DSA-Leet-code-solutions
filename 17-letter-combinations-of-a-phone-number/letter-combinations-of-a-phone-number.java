class Solution {
    Map<Integer,char[]> map=new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        StringBuilder path=new StringBuilder();
        backtrack(digits,0,path,res);
        return res;
    }
    void backtrack(String digits, int index, StringBuilder path, List<String>res){
        if(index==digits.length()){
            res.add(path.toString());
            return;
        }
        char[]options=map.get(digits.charAt(index)-'0');
        for(char c:options){
            path.append(c);
            backtrack(digits,index+1,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}