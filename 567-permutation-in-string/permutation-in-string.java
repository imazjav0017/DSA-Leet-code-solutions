class Solution {
    boolean isValid(int[]src,int[]target){
        for(int i=0;i<26;i++){
            if(target[i]!=0 && src[i]!=target[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(n<m)
            return false;
        int[]target=new int[26];
        for(char c:s1.toCharArray()){
            target[c-'a']++;
        }
        int[]source=new int[26];
        for(int i=0;i<m;i++){
            char c=s2.charAt(i);
            source[c-'a']++;
        }
        if(isValid(source,target))
            return true;
        for(int i=m;i<n;i++){
            char c=s2.charAt(i);
            source[c-'a']++;
            source[s2.charAt(i-m)-'a']--;
            if(isValid(source,target))
                return true;
        }
        return false;

    }
}