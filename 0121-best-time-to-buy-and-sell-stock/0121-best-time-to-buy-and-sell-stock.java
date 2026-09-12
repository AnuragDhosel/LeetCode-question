class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProf = 0;
        
        for(int i=1; i<prices.length; i++){
            int sell = prices[i];

            int currProf = sell - minBuy;
            maxProf = Math.max(currProf , maxProf);
            
            minBuy = Math.min(minBuy , prices[i]);
        }

        return maxProf;
    }
}