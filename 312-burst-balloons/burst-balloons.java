class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[]arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int size=n+2;
        //dp[i][j]=max coins by burtsing baloons between i and j 
        int[][]dp=new int[size][size];

        for(int length=2;length<size;length++){
            for(int left=0;left+length<size;left++){
                int right=left+length;
                for(int k=left+1;k<right;k++){
                    int coins=dp[left][k]+arr[left]*arr[k]*arr[right]+dp[k][right];
                    dp[left][right]=Math.max(dp[left][right],coins);
                }
            }
        }
        return dp[0][size-1];
    }
}