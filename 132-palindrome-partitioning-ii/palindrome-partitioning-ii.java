class Solution {
    public int minCut(String s) {
        int n=s.length();
        //pal[i][j]=is [i..j] a palindrome
        boolean[][]palindrome=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                }
            }
        }
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=-1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(palindrome[j][i-1]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n];
    }
}