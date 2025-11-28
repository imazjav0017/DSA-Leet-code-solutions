class Solution {
    public boolean isAnagram(String s, String t) {
     if(s.length()!=t.length())
        return false;
     int n=s.length();
     char[]s1=s.toCharArray();
     char[]s2=t.toCharArray();
     int []count=new int[26];
     for (char c: s1){
        count[c-'a']++;
     }
     for(char c: s2){
        if(count[c-'a']<1)
            return false;
        count[c-'a']--;
     }
     for(int i:count){
        if(i!=0)
            return false;
     }
     return true;
    }
}