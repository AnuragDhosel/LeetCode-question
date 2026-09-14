class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;

        boolean [] floor = new boolean[n]; // buy
        boolean [] ceil = new boolean[n]; // sell

        if(prices[0] < prices[1]) floor[0] = true;

        for(int i=1; i<n-1; i++){
            if(prices[i-1] < prices[i] && prices[i] >= prices[i+1]){ 
                ceil[i] = true;
            }
            else if(prices[i-1] >= prices[i] && prices[i] < prices[i+1]){ 
                floor[i] = true;
            }
        }

        if(prices[n-2] < prices[n-1]) ceil[n-1] = true;

        int buy = -1;
        int sell = -1;
        int profit = 0;
        for(int i=0; i<n; i++){
            if(floor[i] && !ceil[i]){
                buy = prices[i];
            }
            else if(!floor[i] && ceil[i] && buy != -1){
                sell = prices[i];
                profit += sell - buy;
                buy = -1;
            }
        }

        return profit;
    }
}