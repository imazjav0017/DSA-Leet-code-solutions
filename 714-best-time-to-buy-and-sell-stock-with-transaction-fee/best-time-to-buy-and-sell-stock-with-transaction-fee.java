class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int cash=0; // Max profit if i dont own the stock
        int hold=-prices[0]; //max profit if i do own the stock
        for(int i=1;i<n;i++){
            int prevCash=cash, prevHold=hold;
            cash=Math.max(prevCash, (prevHold+prices[i]-fee));
            hold=Math.max(prevHold,prevCash-prices[i]);
        }
        return cash;
    }
}