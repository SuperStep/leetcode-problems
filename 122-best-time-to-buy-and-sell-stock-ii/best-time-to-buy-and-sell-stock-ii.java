class Solution {
    public int maxProfit(int[] prices) {
        
        int totalProfit = 0;
        int bPrice = 0;
        Boolean b = false;

        for(int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];

            if(i < prices.length - 1 && currentPrice < prices[i+1] && !b) {
                bPrice = currentPrice;
                b = true;
            } else if (b && currentPrice > bPrice && i < prices.length - 1) {
                if(currentPrice > prices[i+1]) {
                    totalProfit += getProfit(bPrice, prices[i]);
                    bPrice = 0;
                    b = false;
                } else if(currentPrice <= prices[i+1]) {
                    continue;
                }
            } else if (b && i == prices.length - 1){
                totalProfit += getProfit(bPrice, prices[i]);
            }

        }
        return totalProfit;
    }

    private int getProfit(int b, int s) {
        if(s<b)
            return 0;
        return s-b;
    }
}