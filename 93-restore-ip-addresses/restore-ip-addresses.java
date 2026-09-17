class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String>res=new ArrayList<>();
        List<String>path=new ArrayList<>();
        backtrack(s,0,path,res);
        return res;
    }
    void backtrack(String s, int start, List<String> path, List<String>res){
       if(path.size()==4){
         if(start==s.length()){
            res.add(String.join(".",path));
         }
         return;
       }
        for(int end=start;end<s.length() && end<start+3;end++){
            String part=s.substring(start,end+1);
            if(part.length()>1 && part.charAt(0)=='0')
                continue;
            if(Integer.parseInt(part)>255)
                continue;
            path.add(part);
            backtrack(s,end+1,path,res);
            path.remove(path.size()-1);
        }
    }
}