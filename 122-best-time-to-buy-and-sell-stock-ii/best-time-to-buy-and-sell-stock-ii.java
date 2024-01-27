class Solution {
    public int maxProfit(int[] prices) {
        int minVal=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++){//7,1,5,3,6,4
            if(minVal>prices[i]){
                minVal=prices[i];//7,1
            }
            if(prices[i]>minVal){
                profit=profit+prices[i]-minVal;
                minVal=prices[i];
            }

        }
        return profit;
    }
}