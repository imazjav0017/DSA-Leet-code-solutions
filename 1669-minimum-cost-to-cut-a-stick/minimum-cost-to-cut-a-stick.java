class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]pos=new int[m+2];
        pos[0]=0;
        pos[m+1]=n;
        for(int i=0;i<m;i++){
            pos[i+1]=cuts[i];
        }
        Arrays.sort(pos);
        int size=m+2;
        //dp[i][j]=min cost to cut b/w i and j 
        int[][]dp=new int[size][size];
        for(int len=2;len<size;len++){
            for(int i=0;i+len<size;i++){
                int j=i+len;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int cost=dp[i][k]+(pos[j]-pos[i])+dp[k][j];
                    dp[i][j]=Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[0][size-1];
    }
}