class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String>path=new ArrayList<>();
        backtrack(s,0,res,path);
        return res;
    }
    void backtrack(String s, int start, List<List<String>> res, List<String>path){
        if(start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<s.length();end++){
            String sub=s.substring(start,end+1);
            if(!isValid(sub))
                continue;
            path.add(sub);
            backtrack(s,end+1,res,path);
            path.remove(path.size()-1);
        }
    }
    boolean isValid(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}