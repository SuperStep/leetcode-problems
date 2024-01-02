class Solution {
    public int maxProfit(int[] prices) {
                if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] maxProfit = new int[n];

        // Forward pass: Calculate maximum profit for the first transaction
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrice);
        }

        // Backward pass: Calculate maximum profit for the second transaction
        int maxPrice = prices[n - 1];
        int maxProfitSecondTransaction = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfitSecondTransaction = Math.max(maxProfitSecondTransaction, maxPrice - prices[i]);
            maxProfit[i] += maxProfitSecondTransaction;
        }

        int result = 0;
        for (int profit : maxProfit) {
            result = Math.max(result, profit);
        }

        return result;
    }
}