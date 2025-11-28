class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length())return false;
        int[]arr=new int[26];
        // Arrays.fill(arr,0);
        for(char c:s.toCharArray())arr[c-'a']++;
        for(char c:t.toCharArray()){
            if(arr[c-'a']<1)return false;
            arr[c-'a']--;
        }
        for(int val:arr)if(val!=0)return false;
        return true;

    }
}