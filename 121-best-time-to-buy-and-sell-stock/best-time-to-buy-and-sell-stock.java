class Solution {
    public int maxProfit(int[] prices) {
        int cheapestPrice = 99999999;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            if(currentPrice < cheapestPrice)
                cheapestPrice = currentPrice;

            int profit = getProfit(cheapestPrice, currentPrice);
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    private int getProfit(int b, int s) {
        return s-b;
    }
}