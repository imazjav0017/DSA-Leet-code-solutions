class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res="";
        int n=strs.length;
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=0;j<n;j++){
                if(j==0)continue;
                if(i==strs[j].length() || strs[j].charAt(i)!=c){
                    return res;
                }
            }
            res+=c;
        }
        return res;
    }
}