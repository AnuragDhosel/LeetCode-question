class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int [] dp = new int[m];
        
        for(int i=0; i<m; i++) // initialise last row of dp
            dp[i] = triangle.get(m-1).get(i);
        
        for(int row=m-2; row>=0; row--){
            for(int col=0; col<triangle.get(row).size(); col++){
                int minValueOfPreviRow = Math.min(dp[col] , dp[col+1]);
                dp[col] = triangle.get(row).get(col) + minValueOfPreviRow;
            }
        }

        return dp[0];
    }
}