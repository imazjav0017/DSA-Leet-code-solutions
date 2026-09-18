class Solution {
    public int numSquares(int n) {
        List<Integer>squares=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            squares.add(i*i);
        }
        int[]dp=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        //dp[x]=number of numbers that sum to n;
        for(int i=0;i<squares.size();i++){
            int num=squares.get(i);
            for(int x=num;x<=n;x++){
                dp[x]=Math.min(dp[x],1+dp[x-num]);
            }
        }
        return dp[n];
    }
}