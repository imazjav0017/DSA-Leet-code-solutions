class Solution {
    int expandingFromCenter(int left,int right,String s, int n){
        int count=0;
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        if(n==1)
            return 1;
        int res=0;
        for(int center=0;center<n;center++){
            int c1=expandingFromCenter(center,center,s,n);
            int c2=expandingFromCenter(center,center+1,s,n);
            res=res+c1+c2;
        }
        return res;
    }
}