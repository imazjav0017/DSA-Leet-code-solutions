class Solution {
    boolean isAlphaNumeric(char c){
        return Character.isLetterOrDigit(c);
    }
    public boolean isPalindrome(String s) {
        int n=s.length();
        int left=0,right=n-1;
        while(left<right){
            while(left<right && !isAlphaNumeric(s.charAt(left))){
                left++;
            }
            while(right>left && !isAlphaNumeric(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}