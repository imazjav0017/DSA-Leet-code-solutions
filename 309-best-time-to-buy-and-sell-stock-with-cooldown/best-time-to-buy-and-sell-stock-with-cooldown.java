class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[]cash=new int[n];//max profit by day i if i dont own the stock
        int[]hold=new int[n];//max profit by day i if i do own the stock
        cash[0]=0;
        hold[0]=-prices[0];
        for(int i=1;i<n;i++){
            cash[i]=Math.max(cash[i-1],hold[i-1]+prices[i]);
            int prevProfit=i>=2?cash[i-2]:0;
            hold[i]=Math.max(hold[i-1],prevProfit-prices[i]);
        }
        return cash[n-1];
    }
}