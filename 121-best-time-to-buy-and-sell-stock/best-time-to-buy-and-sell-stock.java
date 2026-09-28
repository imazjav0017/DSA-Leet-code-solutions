class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int buy=0;
        for(int i=0;i<prices.length;i++){
            max=Math.max(max,prices[i]-prices[buy]);
            if(prices[i]<prices[buy])
                buy=i;
        }
        return max;

    }
}