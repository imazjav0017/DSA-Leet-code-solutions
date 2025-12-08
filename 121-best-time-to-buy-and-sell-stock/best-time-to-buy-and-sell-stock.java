class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=0, sell=1;
        int profit=0;
        while(sell<n){
            int temp=prices[sell]-prices[buy];
            if(temp<0){
                buy=sell;
            }
            sell++;
            if(temp>profit)
                profit=temp;
        }
        return profit;
    }
}