class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(letters[mid]>target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        if(left<n)
            return letters[left];
        else return letters[0];
    }
}