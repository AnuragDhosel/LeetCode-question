class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

         // we can sell in right max element
        int [] sell = new int[n]; // right max array
        sell[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--)
            sell[i] = Math.max(prices[i] , sell[i+1]);

        int maxP = 0;
        for(int i=0; i<n; i++){
            int buy = prices[i];
            int currP = sell[i] - buy;
            maxP = Math.max(currP , maxP);
        }

        return maxP;
    }
}