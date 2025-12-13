class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int found=-1;
        int l=0,r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(letters[mid]>target){
                found=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return found==-1?letters[0]:letters[found];
    }
}