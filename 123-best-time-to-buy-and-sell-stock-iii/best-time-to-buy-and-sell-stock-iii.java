class Solution {
    public int maxProfit(int[] prices) {

        int c1=Integer.MAX_VALUE;
        int c2=Integer.MAX_VALUE;
        int p1=0;
        int p2=0;
        for(int i=0;i<prices.length;i++)
        {
            c1=Math.min(c1,prices[i]);
            p1=Math.max(p1,prices[i]-c1);
            c2=Math.min(c2,prices[i]-p1);
            p2=Math.max(p2,prices[i]-c2);
        }
        return p2;
    }
}