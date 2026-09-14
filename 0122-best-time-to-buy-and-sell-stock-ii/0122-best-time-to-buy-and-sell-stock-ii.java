class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = 0;

        for(int i=0; i<n; i++){
            int totalP = 0;

            int buy = prices[i];
            for(int j=i+1; j<n; j++){
                if(buy > prices[j]){
                    buy = prices[j];
                }
                else if(buy < prices[j]){
                    totalP += prices[j] - buy;
                    buy = prices[j];
                }
            }
            maxP = Math.max(maxP , totalP);
        }

        return maxP;
    }
}