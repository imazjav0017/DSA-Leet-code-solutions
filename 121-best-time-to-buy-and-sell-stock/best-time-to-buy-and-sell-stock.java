class Solution {
    public int maxProfit(int[] prices) {
       int buy=prices[0],sell=0;
       int n=prices.length;
       for(int i=1;i<n;i++){
        if(prices[i]<buy) //cheaper day to buy
            buy=prices[i];
        else if(prices[i]-buy>sell)
            sell=prices[i]-buy;
       }
       return sell;

    }
}