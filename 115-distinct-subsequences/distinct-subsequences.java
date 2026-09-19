class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n){
            return 0;
        }
        //dp[i][j]=number of subsequences of first i chars of s that equals first j characters of t
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)!=t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}